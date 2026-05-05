package com.workorder.ui;

import com.workorder.model.DelovniNalogDto;
import com.workorder.service.DelovniNalogService;

import com.vaadin.collaborationengine.CollaborationEngine;
import com.vaadin.collaborationengine.CollaborationList;
import com.vaadin.collaborationengine.UserInfo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;

import java.util.List;
import java.util.UUID;

/**
 * Glavni pogled za delovne naloge.
 *
 * Uporablja DelovniNalogDto (ne JPA entiteto) ker grid prikazuje JOIN podatke.
 * CollaborationEngine skrbi da vsi delavci vidijo spremembe v realnem času.
 *
 * Za real-time sync med več delavci je uporabljen CollaborationList kot
 * "broadcast channel" >> ko en delavec potrdi ZAČETEK ali KONEC, se grid
 * osvežu vsem ostalim v roku sekunde.
 */
@Route("")
public class DelovniNalogView extends VerticalLayout {

    private static final String STATUS_PL = "PL";
    private static final String STATUS_VD = "VD";
    private static final String STATUS_ND = "ND";
    private static final String STATUS_KO = "KO";
    private static final String STATUS_TG = "TG";

    private static final String TOPIC = "delovni-nalogi";

    private final DelovniNalogService service;
    private final Grid<DelovniNalogDto> grid = new Grid<>(DelovniNalogDto.class, false);

    private final UserInfo localUser = new UserInfo(
            UUID.randomUUID().toString(),
            "Operater" // TODO: zameni ime k bo login?
    );

    public DelovniNalogView(DelovniNalogService service) {
        this.service = service;

        setPadding(false);
        setSpacing(false);
        setSizeFull();

        add(buildBanner(), buildGridSection());

        setupCollaboration();
        refreshGrid();
    }

    //==========================CollaborationEngine==========================================



    private void setupCollaboration() {
        UI ui = UI.getCurrent();
        CollaborationEngine.getInstance().openTopicConnection(
                this, TOPIC, localUser,
                connection -> {
                    CollaborationList list = connection.getNamedList("refresh-trigger");
                    // Ko katerikoli delavec broadcast-a, vsi ostali dobijo refresh
                    list.subscribe(event -> ui.access(this::refreshGrid));
                    return null;
                }
        );
    }

    /**
     * Pošlje signal osveževanja vsem odprtem seansom (vsi terminali v hali).
     * CollaborationEngine to dostavi v ~100ms.
     */
    private void broadcastRefresh() {
        CollaborationEngine.getInstance().openTopicConnection(
                this, TOPIC, localUser,
                connection -> {
                    connection.getNamedList("refresh-trigger").insertLast("r");
                    return null;
                }
        );
    }

    //============================================UI==========================


    private HorizontalLayout buildBanner() {
        H3 naslov = new H3("Delovni nalogi >> montaža panelov");
        naslov.getStyle().set("margin", "0").set("cursor", "default");

        Button temaButton = new Button();
        temaButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        updateThemeButton(temaButton);
        temaButton.addClickListener(e -> {
            ThemeList tl = UI.getCurrent().getElement().getThemeList();
            if (tl.contains(Lumo.DARK)) tl.remove(Lumo.DARK);
            else tl.add(Lumo.DARK);
            updateThemeButton(temaButton);
        });

        HorizontalLayout banner = new HorizontalLayout(naslov, temaButton);
        banner.setWidthFull();
        banner.setAlignItems(Alignment.CENTER);
        banner.setJustifyContentMode(JustifyContentMode.BETWEEN);
        banner.setPadding(true);
        banner.getStyle()
                .set("background", "var(--lumo-contrast-5pct)")
                .set("border-bottom", "1.5px solid var(--lumo-contrast-10pct)")
                .set("flex-shrink", "0");
        return banner;
    }

    private void updateThemeButton(Button btn) {
        boolean dark = UI.getCurrent().getElement().getThemeList().contains(Lumo.DARK);
        btn.setText(dark ? "svetlo" : "temno");
        btn.setIcon(dark ? VaadinIcon.SUN_O.create() : VaadinIcon.MOON.create());
    }

    private VerticalLayout buildGridSection() {
        buildGridColumns();

        grid.setHeightFull();

        // Fallback polling vsako minuto (če CollaborationEngine ne bi bil na voljo)
        UI ui = UI.getCurrent();
        ui.setPollInterval(60_000);
        ui.addPollListener(e -> ui.access(this::refreshGrid));

        Div card = new Div(grid);
        card.setSizeFull();
        card.getStyle()
                .set("border-radius", "12px")
                .set("border", "1.5px solid var(--lumo-contrast-10pct)")
                .set("background", "var(--lumo-contrast-5pct)")
                .set("box-shadow", "0 2px 8px rgba(0,0,0,0.15)")
                .set("overflow", "hidden");

        VerticalLayout section = new VerticalLayout(card);
        section.setPadding(true);
        section.setSizeFull();
        return section;
    }

    private void buildGridColumns() {

        // ---- 0: VRSTNI RED / STATUS BADGE ----
        grid.addComponentColumn(dto -> {
            Span badge = new Span(dto.getPdnInfZapStDp() != null
                    ? String.valueOf(dto.getPdnInfZapStDp()) : "-");
            badge.getStyle()
                    .set("padding", "4px 10px")
                    .set("border-radius", "12px")
                    .set("font-weight", "bold");

            String prev = dto.getPrevStatus();
            if (prev == null || STATUS_PL.equals(prev) || STATUS_TG.equals(prev)) {
                // Utripa >> čakamo da prejšnja operacija pride na vrsto
                badge.getStyle()
                        .set("background", "#FF3333")
                        .set("color", "white")
                        .set("animation", "blink 1s step-start infinite");
                badge.getElement().executeJs(
                        "if(!document.getElementById('blink-style')){" +
                                "var s=document.createElement('style');s.id='blink-style';" +
                                "s.textContent='@keyframes blink{50%{opacity:0}}';" +
                                "document.head.appendChild(s);}");
            } else if (STATUS_VD.equals(prev)) {
                // Prejšnja je v delu >> čakamo
                badge.getStyle().set("background", "#808080").set("color", "white");
            } else if (STATUS_KO.equals(prev)) {
                // Prejšnja končana >> ta je na vrsti (zelena)
                badge.getStyle().set("background", "#00CC44").set("color", "white");
            }

            return badge;
        }).setHeader("Vrstni red").setWidth("110px").setFlexGrow(0);

        // ---- 1: DELOVNI NALOG ----
        grid.addComponentColumn(dto -> {
            VerticalLayout cell = new VerticalLayout();
            cell.setSpacing(false);
            cell.setPadding(false);
            cell.getStyle().set("gap", "2px");

            Span stNaloga = new Span(
                    (dto.getPdnStDelNaloga() != null ? dto.getPdnStDelNaloga().toString() : "") +
                            (dto.getPdnSifMp() != null ? "  [" + dto.getPdnSifMp() + "]" : "")
            );
            stNaloga.getStyle().set("font-weight", "bold");

            Span naziv = new Span(dto.getPdnNazivDp() != null ? dto.getPdnNazivDp() : "");
            naziv.getStyle().set("font-size", "0.85em");

            Span mpNaziv = new Span(dto.getMpNaziv() != null ? dto.getMpNaziv() : "");
            mpNaziv.getStyle()
                    .set("font-size", "0.8em")
                    .set("color", "var(--lumo-secondary-text-color)");

            cell.add(stNaloga, naziv, mpNaziv);

            // Barva ozadja glede na vrsto naloga (DNpSifVrsteDN)
            String vrsta = dto.getDnpSifVrsteDN();
            String barva = switch (vrsta != null ? vrsta.trim() : "") {
                case "20" -> "#fffacd";  // rumena
                case "30" -> "#ffcccc";  // rdeča
                case "60" -> "#ccffcc";  // zelena
                case "80" -> "#ffccff";  // roza
                case "90" -> "#e0ccff";  // vijolična
                default   -> null;
            };
            if (barva != null) {
                cell.getStyle()
                        .set("background", barva)
                        .set("border-radius", "6px")
                        .set("padding", "4px 6px");
            }
            return cell;
        }).setHeader("Delovni nalog").setFlexGrow(2).setWidth("280px");

        // ---- 2: ZA IZDELAVO PANELOV (preostalo) ----
        grid.addColumn(dto -> {
            double zaIzd   = dto.getDnpKolZaIzdelavo() != null ? dto.getDnpKolZaIzdelavo() : 0;
            double pakiran = dto.getMpKolPakiranMp() != null && dto.getMpKolPakiranMp() > 0
                    ? dto.getMpKolPakiranMp() : 1;
            double sum1    = dto.getSumEuCustom1() != null ? dto.getSumEuCustom1() : 0;
            int preostalo  = (int) Math.ceil(zaIzd / pakiran) - (int) sum1;
            return preostalo + " pan";
        }).setHeader("Za izdelavo").setWidth("120px").setFlexGrow(0);

        // ---- 3: ZAČETEK / KONEC gumba ----
        grid.addComponentColumn(dto -> {
            String status = dto.getPdnStatus();

            Button zacetek = new Button("ZAČETEK", VaadinIcon.PLAY.create());
            Button konec   = new Button("KONEC",   VaadinIcon.STOP.create());
            zacetek.addThemeVariants(ButtonVariant.LUMO_SMALL);
            konec.addThemeVariants(ButtonVariant.LUMO_SMALL);

            // Barva ozadja gumbov glede na status
            if (STATUS_VD.equals(status)) {
                zacetek.getStyle().set("background-color", "#FFD700").set("color", "#333");
                konec.getStyle().set("background-color", "#FFD700").set("color", "#333");
            } else if (STATUS_ND.equals(status)) {
                zacetek.getStyle().set("background-color", "#4169E1").set("color", "white");
                konec.getStyle().set("background-color", "#4169E1").set("color", "white");
            }

            // ZAČETEK je aktiven ko nalog NI v delu in NI končan
            zacetek.setEnabled(!STATUS_VD.equals(status) && !STATUS_KO.equals(status));
            // KONEC je aktiven samo ko je nalog v delu (VD)
            konec.setEnabled(STATUS_VD.equals(status));

            zacetek.addClickListener(e -> handleZacetek(dto));
            konec.addClickListener(e -> handleKonec(dto));

            HorizontalLayout gumbi = new HorizontalLayout(zacetek, konec);
            gumbi.setSpacing(true);
            gumbi.setPadding(false);
            return gumbi;
        }).setHeader("Začetek / Konec").setWidth("210px").setFlexGrow(0);

        // ---- 4: PDF ----
        grid.addComponentColumn(dto -> {
            Button pdf = new Button("PDF", VaadinIcon.FILE_TEXT_O.create());
            pdf.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_CONTRAST);

            boolean imaPdf = dto.getMpRisbaFname() != null && !dto.getMpRisbaFname().isBlank();
            pdf.setEnabled(imaPdf);

            pdf.addClickListener(e -> {
                String pot = "file:////192.168.0.170/Proizvodnja/"
                        + dto.getMpRisbaFname().replace("\\", "/");
                UI.getCurrent().getPage().open(pot);
            });
            return pdf;
        }).setHeader("PDF").setWidth("80px").setFlexGrow(0);

        // ---- 5: IZDELANO PANELOV ----
        grid.addColumn(dto -> {
            Double sum = dto.getSumEuCustom2();
            return (sum != null ? sum.intValue() : 0) + " pan";
        }).setHeader("Izdelano").setWidth("100px").setFlexGrow(0);

        // ---- 6: OPOMBA ----
        grid.addColumn(DelovniNalogDto::getMpOpomba)
                .setHeader("Opomba")
                .setFlexGrow(1)
                .setWidth("160px");

        // ---- 7: NASLEDNJA OPERACIJA ----
        grid.addColumn(DelovniNalogDto::getNextPdnNazivDp)
                .setHeader("Naslednja op.")
                .setFlexGrow(1)
                .setWidth("160px");
    }

    // ===============================================================================================
    private void refreshGrid() {
        List<DelovniNalogDto> nalogi = service.getNalogi();
        grid.setItems(nalogi);
    }

    private void handleZacetek(DelovniNalogDto dto) {
        // ZAČETEK ni mogoč če je nalog že v delu
        if (dto.isVDelu()) {
            showNotification("Nalog je že v delu!", true);
            return;
        }
        try {
            service.zacniNalog(dto, localUser.getName());
            broadcastRefresh(); // osvežimo vse terminale
            showNotification("Nalog " + dto.getPdnStDelNaloga() + " >> začetek zabeležen.", false);
        } catch (Exception e) {
            showNotification("Napaka: " + e.getMessage(), true);
        }
    }

    private void handleKonec(DelovniNalogDto dto) {
        // POPRAVEK: KONEC je mogoč SAMO ko je nalog v delu (VD).
        // Prej je bila logika obrnjena >> vračala napako prav ko je bil VD!
        if (!dto.isVDelu()) {
            showNotification("Nalog ni v stanju 'V delu'. Najprej pritisni ZAČETEK.", true);
            return;
        }

        double zaIzd   = dto.getDnpKolZaIzdelavo() != null ? dto.getDnpKolZaIzdelavo() : 0;
        double pakiran = dto.getMpKolPakiranMp() != null && dto.getMpKolPakiranMp() > 0
                ? dto.getMpKolPakiranMp() : 1;
        double sumDob  = dto.getSumEuKolDobrih() != null ? dto.getSumEuKolDobrih() : 0;
        // Maksimalno preostalih panelov (zaokroženo navzgor)
        int maxPan = (int) Math.ceil((zaIzd - sumDob) / pakiran);
        if (maxPan < 1) maxPan = 1;

        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Konec: nalog " + dto.getPdnStDelNaloga());
        dialog.setWidth("360px");

        Span info = new Span("Preostalo za izdelat: " + maxPan + " panelov");
        info.getStyle()
                .set("color", "var(--lumo-secondary-text-color)")
                .set("font-size", "0.9em");

        IntegerField paneliField = new IntegerField("Število izdelanih panelov");
        paneliField.setMin(1);
        paneliField.setMax(maxPan);
        paneliField.setValue(maxPan);
        paneliField.setStepButtonsVisible(true);
        paneliField.setWidthFull();

        Button potrdi  = new Button("Potrdi", VaadinIcon.CHECK.create());
        Button prekini = new Button("Prekini", VaadinIcon.CLOSE.create());
        potrdi.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        prekini.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        prekini.addClickListener(e -> dialog.close());

        final int maxPanFinal = maxPan;
        potrdi.addClickListener(e -> {
            Integer vpisano = paneliField.getValue();
            if (vpisano == null || vpisano <= 0) {
                showNotification("Vnesi veljavno število panelov!", true);
                return;
            }
            // Preveri da skupaj ne preseže naročenega
            double pankos   = vpisano * pakiran;
            double sumTotal = sumDob + pankos;
            if (sumTotal > zaIzd) {
                showNotification("NAPAKA: Vpisanih je več kot lansiranih! Maks: "
                        + maxPanFinal + " pan", true);
                return;
            }
            try {
                service.zakljuciNalog(dto, vpisano, localUser.getName());
                dialog.close();
                broadcastRefresh(); // osvežimo vse terminale
                showNotification("Nalog " + dto.getPdnStDelNaloga() + " >> konec zabeležen.", false);
            } catch (Exception ex) {
                showNotification("Napaka: " + ex.getMessage(), true);
            }
        });

        dialog.add(new VerticalLayout(info, paneliField));
        dialog.getFooter().add(prekini, potrdi);
        dialog.open();
    }

    //======helpers================================================================

    private void showNotification(String text, boolean isError) {
        Notification n = new Notification(text, 5000);
        n.addThemeVariants(isError
                ? NotificationVariant.LUMO_ERROR
                : NotificationVariant.LUMO_SUCCESS);
        n.setPosition(Notification.Position.TOP_CENTER);
        n.open();
    }
}