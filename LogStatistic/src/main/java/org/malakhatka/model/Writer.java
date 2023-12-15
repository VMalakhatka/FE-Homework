package org.malakhatka.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.malakhatka.exception.ReaderException;
import org.malakhatka.log.Logger;
import org.malakhatka.log.event.Event;
import org.malakhatka.util.EventGenerator;
import org.malakhatka.util.ObjectMapperUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Writer implements Runnable{
    private final Logger logger;
    private final ObjectMapper mapper;


    public Writer(Logger logger) {
        this.logger = logger;
        this.mapper= ObjectMapperUtil.getObjectMapper();
    }

    private void write(Event event){
        String js;
        try {
            js = mapper.writeValueAsString(event)+System.lineSeparator();
        } catch (JsonProcessingException e) {
            throw new WrongThreadException(String.format("Проблема преобразвания %s в json",event),e);
        }
        logger.startWriting();
        System.out.printf("W. %d начал писать%n", Thread.currentThread().getId());
        logger.writeAtEnd(js);

        logger.endWriting();
        System.out.printf("W. %d закончил запись в лог%n", Thread.currentThread().getId());

    }


    @Override
    public void run() {
        while (!Thread.interrupted()){
            write(EventGenerator.nextEvent());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new ReaderException(String.format("R. %d прерван во время ожидания%n",Thread.currentThread().getId()),e);
            }
        }

    }
}
