package org.malakhatka.log.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Comparable<Event>{
    private ZonedDateTime zonedDateTime;
    private EventLevel level;
    private String message;

    @Override
    public int compareTo(Event o) {
        return this.zonedDateTime.compareTo(o.zonedDateTime);
    }
}
