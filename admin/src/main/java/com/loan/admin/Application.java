package com.loan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by shuttle on 5/22/17.
 */
@SpringBootApplication
@ServletComponentScan
@ComponentScan(value = { "com.loan.datasource", "com.loan.admin", "springfox.documentation"})
@PropertySource("classpath:/jdbc.properties")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
