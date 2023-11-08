package com.example.student_registration.map;

import com.example.student_registration.Student;

import java.util.Map;

abstract public class StudentsMap {

    abstract public Map<Integer, Student> getMap();

    abstract public int getLastId();

    abstract public void increaseLastId();
}

