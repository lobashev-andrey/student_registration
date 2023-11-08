package com.example.student_registration;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {

    private static int count = 0;

    private final int id;
    private final Object object;

    public Event(Object object) {
        this.id = count++;
        this.object = object;
    }
}
