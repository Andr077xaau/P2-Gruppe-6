package com.smarthome;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Smart Home web application.
 *
 * @SpringBootApplication  — starts Spring Boot (embedded Tomcat server included)
 * @EnableVaadin           — tells Spring to scan for Vaadin views (@Route classes)
 *
 * To run: mvn spring-boot:run
 * Then open: http://localhost:8080
 */
@SpringBootApplication
@EnableVaadin
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
