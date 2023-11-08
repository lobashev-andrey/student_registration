package com.example.student_registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@AllArgsConstructor
public class Student {


    private int id;
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return "Student №" + id +
                ": " + firstName + " " + lastName + ". "  + age +
                " years old";
    }
}
