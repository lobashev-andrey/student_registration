package com.example.student_registration.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.students")
public class ConfProperties {

    private boolean init;
    private int num;
}
