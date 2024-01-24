package org.example.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public record ToDoTaskProperties(@Value("${default.title}") String title,
                                 @Value("${default.description}") String description,
                                 @Value("${default.priority}") int priority) {
}
