package org.malakhatka.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.malakhatka.exception.ReaderException;
import org.malakhatka.log.Logger;
import org.malakhatka.log.event.Event;
import org.malakhatka.util.ObjectMapperUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Reader implements Runnable{
    private final Logger logger;
    private final ObjectMapper mapper;
    private List<Event> messages;
    private int lastReadLineN;

    public Reader(Logger logger) {
        this.logger = logger;
        this.mapper= ObjectMapperUtil.getObjectMapper();
        this.messages=new ArrayList<>();
        lastReadLineN=0;
    }

    private List<Event> readNew(){
        logger.startReading();
        int newLineCount = logger.getLieneCount()-lastReadLineN;
        System.out.printf("R. %d начал читать %d строк из лога %n", Thread.currentThread().getId(), newLineCount);
        List<String> lastJsons=logger.readLastNLines(newLineCount);
        logger.endReading();
        System.out.printf("R. %d прочитал из лога %d строк: %s%n", Thread.currentThread().getId(),lastJsons.size(),lastJsons);
        List<Event> lastEvents=toEventList(lastJsons);
        System.out.printf("R. %d сконвертировал json в %d собітий%n", Thread.currentThread().getId(),lastEvents.size());
        return lastEvents;
    }

    private List<Event> toEventList(List<String> jsons){
        return new ArrayList<>(
        jsons.stream()
                .map(js-> {
                    try {
                        return Optional.ofNullable(mapper.readValue(js,Event.class));
                    } catch (JsonProcessingException e) {
                        System.err.printf("Не могу конвертировать json в Event: %s%n%s%n",js,e.getMessage());
                        return Optional.empty();
                    }
                })
                .filter(Optional::isPresent)
                .map(op->(Event)op.get())
                .sorted().toList());
    }

    public List<Event> getMessages() {
        List<Event> events = new ArrayList<>(messages);
        messages.clear();
        return events;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            messages.addAll(readNew());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new ReaderException(String.format("R. %d прерван во время ожидания%n",Thread.currentThread().getId()),e);
            }
        }

    }
}
