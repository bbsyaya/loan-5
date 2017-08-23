package com.loan.api;

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
@ComponentScan(value = { "com.loan.api", "springfox.documentation"})
@PropertySource("classpath:/application.properties")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
