package com.loan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by shuttle on 5/22/17.
 */
@SpringBootApplication
//@ServletComponentScan
@EnableAutoConfiguration
@ComponentScan(value = { "com.loan.datasource", "com.loan.admin", "springfox.documentation"})
@EnableJpaRepositories("com.loan.datasource.dao.springdata")
@EntityScan("com.loan.datasource.entities.jpa")
@PropertySource("classpath:/application.properties")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
