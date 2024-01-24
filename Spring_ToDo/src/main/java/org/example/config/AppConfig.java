package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"org.example.properties", "org.example.todo",
        "org.example.notification", "org.example.connector"})
@PropertySource("classpath:aplication.properties")
public class AppConfig {

}
