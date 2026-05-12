package com.workorder.ui;

import com.vaadin.flow.component.textfield.TextArea;
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

    private int rowCounter = 0;

    public DelovniNalogView(DelovniNalogService service) {
        this.service = service;

        setPadding(false);
        setSpacing(false);

        applyCookie();

        setSizeFull();

        VerticalLayout ostalo = new VerticalLayout(
                buildHeader(),
                buildGrid()
        );
        ostalo.setPadding(true);
        ostalo.setSpacing(true);
        ostalo.setSizeFull();

        add(buildBanner(), ostalo);

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
        Image logo = new Image("slike/logo-transparent.png", "logo");
        logo.setHeight("60px");

        HorizontalLayout banner = new HorizontalLayout(logo);
        banner.setAlignItems(Alignment.CENTER);
        banner.setWidth("100%");
        banner.setPadding(true);
        banner.getStyle().set("height", "64px");
        banner.setClassName("banner-barva");

        return banner;
    }

    private HorizontalLayout buildHeader() {
        H2 naslov = new H2("Beleženje delovnih nalogov");
        naslov.getStyle().set("cursor", "default");

        H5 podNaslov = new H5("Montaža panelov (delovni center št. 20)");
        podNaslov.getStyle()
                .set("cursor", "default")
                .set("font-weight", "normal");

        VerticalLayout naslovBlock = new VerticalLayout(naslov, podNaslov);
        naslovBlock.setSpacing(false);
        naslovBlock.setPadding(false);
        naslovBlock.getStyle().set("gap", "5px");

        Button temaButton = new Button();
        temaButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        updateThemeButton(temaButton);

        temaButton.addClickListener(click -> {
            ThemeList themeList = UI.getCurrent().getElement().getThemeList();
            if (themeList.contains(Lumo.DARK)) {
                themeList.remove(Lumo.DARK);
                ((Button) click.getSource()).setText("temno");
                saveCookie("light");
            } else {
                themeList.add(Lumo.DARK);
                ((Button) click.getSource()).setText("svetlo");
                saveCookie("dark");
            }
            updateThemeButton(temaButton);
        });

        HorizontalLayout header = new HorizontalLayout(naslovBlock, temaButton);
        header.setWidthFull();
        header.setAlignItems(Alignment.CENTER);
        header.setJustifyContentMode(JustifyContentMode.BETWEEN);
        return header;
    }

    private void updateThemeButton(Button btn) {
        boolean dark = UI.getCurrent().getElement().getThemeList().contains(Lumo.DARK);
        btn.setText(dark ? "svetlo" : "temno");
        btn.setIcon(dark ? VaadinIcon.SUN_O.create() : VaadinIcon.MOON.create());
    }

    private VerticalLayout buildGrid() {
        buildGridColumns();

        grid.getStyle().set("border", "none");
        grid.getStyle().set("--lumo-base-color", "transparent");

        grid.setHeightFull();

        //iz DB -> webapp na 1sec
        // Fallback polling(če CollaborationEngine ne bi delu)
        UI ui = UI.getCurrent();
        ui.setPollInterval(1_000); //1sec
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
        // 0: VRSTNI RED / STATUS BADGE  <<
        grid.addComponentColumn(dto -> {
            rowCounter++;
            Span badge = new Span(String.valueOf(rowCounter));
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

        // 1: DELOVNI NALOG  <<
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

            //barva ozadja glede na vrsto naloga (DNpSifVrsteDN)
            String vrsta = dto.getDnpSifVrsteDN();
            String barva = switch (vrsta != null ? vrsta.trim() : "") {
                case "20" -> "var(--barva-rumena)";
                case "30" -> "var(--barva-rdeca)";
                case "60" -> "var(--barva-zelena)";
                case "80" -> "var(--barva-roza)";
                case "90" -> "var(--barva-vijolicna)";
                default   -> null;
            };
            if (barva != null) {
                cell.getStyle()
                        .set("background", barva)
                        .set("border-radius", "6px")
                        .set("padding", "4px 6px");
            }
            return cell;


        }).setHeader("Delovni nalog").setFlexGrow(2).setWidth("220px");

        // 2: ZA IZDELAVO PANELOV (preostalo)  <<
        grid.addColumn(dto -> {
            double zaIzd   = dto.getDnpKolZaIzdelavo() != null ? dto.getDnpKolZaIzdelavo() : 0;
            int preostalo = (int)(zaIzd - (dto.getSumEuKolDobrih() != null ? dto.getSumEuKolDobrih() : 0));
            return preostalo + " kos";
        }).setHeader("Za izdelavo").setWidth("110px").setFlexGrow(0);

        // 3: ZAČETEK / KONEC gumba  <<
        grid.addComponentColumn(dto -> {
            String status = dto.getPdnStatus();

            Button zacetek = new Button("ZAČETEK", VaadinIcon.PLAY.create());
            Button konec   = new Button("KONEC",   VaadinIcon.STOP.create());
            zacetek.addThemeVariants(ButtonVariant.LUMO_SMALL);
            konec.addThemeVariants(ButtonVariant.LUMO_SMALL);

            //po default če je STATUS_PL je barva ozadja bela <<<<<<
            if (STATUS_VD.equals(status)) { //status: v delu
                zacetek.getStyle().set("background-color", "#FFD700").set("color", "#333");
                konec.getStyle().set("background-color", "#FFD700").set("color", "#333");
            } else if (STATUS_ND.equals(status)) { //status: ne dokončano
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
        }).setHeader("").setWidth("230px").setFlexGrow(0);

        // 4: PDF  <<
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

        // 5: IZDELANO KOSOU  <<
        grid.addComponentColumn(dto -> {
            Double sum = dto.getSumEuKolDobrih();
            int kos = sum != null ? sum.intValue() : 0;
            Div d = new Div();
            d.setText(kos + " kos");
            if (kos != 0) d.getStyle().set("font-weight", "bold");
            return d;
        }).setHeader("Že izdelano").setWidth("100px").setFlexGrow(0);

        // 6: OPOMBA  <<
        grid.addColumn(DelovniNalogDto::getMpOpomba)
                .setHeader("Opomba")
                .setFlexGrow(1)
                .setWidth("160px");

        // 7: NASLEDNJA OPERACIJA  <<
        grid.addColumn(DelovniNalogDto::getNextPdnNazivDp)
                .setHeader("Naslednja op.")
                .setFlexGrow(1)
                .setWidth("160px");
    }

    // ===============================================================================================
    private void refreshGrid() {
        rowCounter = 0;
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
        if (!dto.isVDelu()) {
            showNotification("Nalog ni v stanju 'V delu'. Najprej pritisni ZAČETEK.", true);
            return;
        }

        double zaIzd   = dto.getDnpKolZaIzdelavo() != null ? dto.getDnpKolZaIzdelavo() : 0;
        double sumDob = dto.getSumEuKolDobrih() != null ? dto.getSumEuKolDobrih() : 0;
        int maxKos = (int)(zaIzd - sumDob);
        if (maxKos < 1) maxKos = 1;

        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Konec: nalog " + dto.getPdnStDelNaloga());
        dialog.setWidth("360px");

        Span info = new Span("Preostalo za izdelat: " + maxKos + " kosov");
        info.getStyle()
                .set("color", "var(--lumo-secondary-text-color)")
                .set("font-size", "0.9em");

        IntegerField paneliField = new IntegerField("Količina (kosi)");
        paneliField.setMin(1);
        paneliField.setMax(maxKos);
        paneliField.setValue(maxKos);
        paneliField.setStepButtonsVisible(true);
        paneliField.setWidthFull();

        Button potrdi  = new Button("Potrdi", VaadinIcon.CHECK.create());
        Button prekini = new Button("Prekini", VaadinIcon.CLOSE.create());
        potrdi.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        prekini.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        prekini.addClickListener(e -> dialog.close());

        //možnost dodajanja opombe ob koncu
        TextArea opomba = new TextArea("Opomba");
        opomba.setPlaceholder("Neobvezno...");
        opomba.setWidthFull();
        opomba.setMaxLength(500);


        final int maxKosFinal = maxKos;
        potrdi.addClickListener(e -> {
            Integer vpisano = paneliField.getValue();
            if (vpisano == null || vpisano <= 0) {
                showNotification("Vnesi veljavno količino!", true);
                return;
            }
            double sumTotal = sumDob + vpisano; //prev: ne preseže naročenga
            if (sumTotal > zaIzd) {
                showNotification("NAPAKA: Vpisanih je več kot lansiranih! Maks: "
                        + maxKosFinal + " kos", true);
                return;
            }
            try {
                service.zakljuciNalog(dto, vpisano, localUser.getName(), opomba.getValue());
                dialog.close();
                broadcastRefresh(); // osvežimo vse terminale
                showNotification("Nalog " + dto.getPdnStDelNaloga() + " >> konec zabeležen.", false);
            } catch (Exception ex) {
                showNotification("Napaka: " + ex.getMessage(), true);
            }
        });

        dialog.add(new VerticalLayout(info, paneliField, opomba));
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

    //=============================================
    // cookie za shranjevanje zadnje izbrane teme
    //=============================================

    private void saveCookie(String theme) {
        UI.getCurrent().getPage().executeJs(
                "document.cookie = 'tema=' + $0 + '; max-age=' + (7*24*60*60) + '; path=/'",
                theme
        );
    }

    private void applyCookie(){
        UI.getCurrent().getPage().executeJs(
                "return document.cookie.split(';').map(c => c.trim()).find(c => c.startsWith('tema='))?.split('=')[1] || 'dark';"
        ).then(String.class, theme -> {
            ThemeList themeList = UI.getCurrent().getElement().getThemeList();
            if ("dark".equals(theme)) {
                themeList.add(Lumo.DARK);
            } else {
                themeList.remove(Lumo.DARK);
            }
        });
    }
}