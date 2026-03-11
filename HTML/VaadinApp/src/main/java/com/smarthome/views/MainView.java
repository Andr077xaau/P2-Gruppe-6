package com.smarthome.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.component.UI;

/**
 * Main/Start page — shown after a successful login.
 *
 * @Route("main") — maps this view to: http://localhost:8080/main
 */
@Route("main")
@PageTitle("Start | Smart Home")
@AnonymousAllowed
public class MainView extends VerticalLayout {

    public MainView() {
        // Center content on the page
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        // --- Welcome message ---
        H2 welcome = new H2("Velkommen");

        // --- Placeholder cards (add real content here later) ---
        Paragraph energyCard = new Paragraph("Energiforbrug: -- kWh");
        Paragraph devicesCard = new Paragraph("Aktive enheder: --");

        // --- Log out button ---
        Button logoutButton = new Button("Log ud");
        logoutButton.addClickListener(event -> {
            // Navigate back to login page
            UI.getCurrent().navigate(LoginView.class);
        });

        add(welcome, energyCard, devicesCard, logoutButton);
    }
}
