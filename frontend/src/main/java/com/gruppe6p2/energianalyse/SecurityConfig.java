package com.gruppe6p2.energianalyse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration    // Spring reads this class for configuration settings on startup
@EnableWebSecurity // Turns on Spring Security for the whole application
public class SecurityConfig {

    @Bean // Spring calls this once on startup and reuses the result for every request
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable Spring's CSRF protection — Vaadin handles its own CSRF internally

            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Temporarily allow everything — just to confirm views work
            )
            .formLogin(form -> form
                .loginPage("/login")           // Use our LoginView as the login page
                .defaultSuccessUrl("/", true)  // After successful login, go to the main dashboard
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login")    // After logout, go back to login page
            );

        return http.build(); // Build and return the finished security configuration
    }

    @Bean // Registers the password encoder so other classes can ask Spring for it
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt algorithm — matches the hashing in PasswordUtil.java
    }
}
