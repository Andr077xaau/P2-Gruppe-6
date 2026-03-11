package com.smarthome.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("")
@PageTitle("Login | Smart Home")
@AnonymousAllowed
public class LoginView extends VerticalLayout {

    public LoginView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        H1 title = new H1("Energi Management System");

        // Built-in Vaadin login form (username + password + login button)
        LoginForm loginForm = new LoginForm();

        loginForm.addLoginListener(event -> {
            if (isValidUser(event.getUsername(), event.getPassword())) {
                UI.getCurrent().navigate(MainView.class);
            } else {
                loginForm.setError(true); // shows built-in red error message
            }
        });

        add(title, loginForm);
    }

    /**
     * TODO: Replace with a real database lookup using UserDAO.
     */
    private boolean isValidUser(String username, String password) {
        return "admin".equals(username) && "1234".equals(password);
    }
}
