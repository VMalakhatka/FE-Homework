package org.malakhatka.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.malakhatka.log.event.Event;
import org.malakhatka.log.event.EventLevel;

import java.time.ZonedDateTime;
import java.util.Random;

public class EventGenerator {
    private static final Random RND=new Random();
    private EventGenerator(){}
    public static Event nextEvent(){
        return new Event(ZonedDateTime.now(),nextLevel(), RandomStringUtils.randomAlphabetic(15));
    }

    private static EventLevel nextLevel(){
        return EventLevel.values()[RND.nextInt(EventLevel.values().length)];
    }
}
