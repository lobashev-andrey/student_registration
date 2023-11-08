package com.example.student_registration;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EventMaker extends ApplicationEvent {

    private Event event;

    public EventMaker(Object source, Event event) {
        super(source);
        this.event = event;
    }
}
