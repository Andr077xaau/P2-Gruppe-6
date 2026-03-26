package com.gruppe6p2.energianalyse;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")         // This view is at http://localhost:8080/ — the default page after login
@PageTitle("Dashboard") // Browser tab title
public class MainView extends VerticalLayout {

    public MainView() {
        add(new H1("Welcome to EnergiAnalyse")); // Main heading
        add(new Paragraph("You are logged in.")); // Placeholder text — we will add real content later
    }
}
