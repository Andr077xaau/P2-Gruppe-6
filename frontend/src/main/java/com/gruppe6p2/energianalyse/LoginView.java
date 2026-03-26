package com.gruppe6p2.energianalyse;

  import com.vaadin.flow.component.html.H1;
  import com.vaadin.flow.component.login.LoginForm;
  import com.vaadin.flow.component.orderedlayout.VerticalLayout;
  import com.vaadin.flow.router.BeforeEnterEvent;
  import com.vaadin.flow.router.BeforeEnterObserver;
  import com.vaadin.flow.router.PageTitle;
  import com.vaadin.flow.router.Route;
  import com.vaadin.flow.server.auth.AnonymousAllowed;

  @Route("login")           // This view is at http://localhost:8080/login
  @PageTitle("Login")       // Browser tab title
  @AnonymousAllowed         // Anyone can access this page without being logged in
  public class LoginView extends VerticalLayout implements BeforeEnterObserver {

      private final LoginForm loginForm = new LoginForm();

      public LoginView() {
          setSizeFull();                          // Fill the whole page
          setAlignItems(Alignment.CENTER);        // Center horizontally
          setJustifyContentMode(JustifyContentMode.CENTER); // Center vertically

          loginForm.setAction("login");           // Submits to Spring Security's /login endpoint

          add(new H1("Energi Management System"), loginForm); // Add title and login form to the page
      }

      @Override
      public void beforeEnter(BeforeEnterEvent event) {
          // If the URL has ?error, show an error message on the form
          if (event.getLocation().getQueryParameters().getParameters().containsKey("error")) {
              loginForm.setError(true);
          }
      }
  }