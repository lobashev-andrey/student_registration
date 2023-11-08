package com.example.student_registration.map;

import com.example.student_registration.Student;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmptyStudentsMap extends StudentsMap {

    private final Map<Integer, Student> map = new HashMap<>();
    private int lastId = 0;

    @Override
    public Map<Integer, Student> getMap() {
        return map;
    }

    @Override
    public int getLastId() {
        return lastId;
    }

    @Override
    public void increaseLastId() {
        lastId++;
    }
}
