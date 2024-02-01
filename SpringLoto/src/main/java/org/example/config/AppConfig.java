package org.example.config;


import org.example.model.field.Field;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan( {"org.example.model.field","org.example.controller",
        "org.example.view"})
public class AppConfig {


    @Bean
    public Field fieldPeople(){
        return new Field(true,
                "People");
    }

    @Bean
    public Field fieldComputer(){
        return new Field(false,
                "Computer");
    }


//    @Order(3)
//    @Bean
//    public Color yellow(){
//        return new Color("Yellow");


}

