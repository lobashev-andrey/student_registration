package com.example.student_registration;


import com.example.student_registration.map.StudentsMap;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Component;


@ShellComponent
@RequiredArgsConstructor
public class StudentsManager {

    private final StudentsMap studentsMap;
    private final ApplicationEventPublisher publisher;

    @ShellMethod(key = "g")
    public void getAllStudentsList(){
        if(studentsMap.getMap().isEmpty()){
            System.out.println("List of students is empty yet");
            return;
        }
        System.out.println("List of students:");
        studentsMap.getMap().values().forEach(System.out::println);
    }

    @ShellMethod(key = "c")
    public void cleanStudentsList(){
        studentsMap.getMap().clear();
        System.out.println("List of students is abandoned");
    }

    @ShellMethod(key = "a")
    public void addStudent(@ShellOption(value = "f") String firstName,
                           @ShellOption(value = "l") String lastName,
                           @ShellOption(value = "a") int age){
        int id = studentsMap.getLastId() + 1;
        studentsMap.increaseLastId();
        Student student = new Student(id, firstName, lastName, age);
        studentsMap.getMap().put(id, student);
        publishEvent(student);
    }

    @ShellMethod(key = "d")
    public void deleteStudent(int id){
        if(!studentsMap.getMap().containsKey(id)){
            System.out.println("There is not such id in students list");
            return;
        }
        studentsMap.getMap().remove(id);
        publishEvent(id);
    }

    public void publishEvent(Object o){
        Event event = new Event(o);
        EventMaker eventMaker = new EventMaker(this, event);
        publisher.publishEvent(eventMaker);
    }

}
