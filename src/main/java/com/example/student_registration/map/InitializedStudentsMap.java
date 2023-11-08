package com.example.student_registration.map;

import com.example.student_registration.Student;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConditionalOnExpression("${app.students.init}")
@Primary
@RequiredArgsConstructor
public class InitializedStudentsMap extends StudentsMap {

    @Value("${app.students.num}")
    private int num;
    private int lastId = 0;
    private final Map<Integer, Student> map = new HashMap<>();

    @PostConstruct
    public void initializeMap() {
        for (int i = 0; i < num; i++) {
            increaseLastId();
            Student student = new Student(lastId,
                    "FistName" + lastId,
                    "LastName" + lastId,
                    (int) Math.round(16 + 10 * Math.random()));
            map.put(lastId, student);
        }
    }

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
