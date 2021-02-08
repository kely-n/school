package com.example.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
//@ComponentScan(basePackages={"com.example.school.controller"})
public class SchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[] {SchoolApplication.class , WebApplicationInitializer.class}, args);
    }

}
