package com.example.student_registration;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AllListeners {

    @EventListener(EventMaker.class)
    public void listen(EventMaker eventMaker){
        System.out.println(eventMaker.getEvent().getObject());
    }
}
