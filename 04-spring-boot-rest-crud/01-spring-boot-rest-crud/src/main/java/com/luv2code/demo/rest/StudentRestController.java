package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entities.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api") 
public class StudentRestController {
    // define field data
    private List<Student> students;

    // define @PostConstruct to load student data, annotation นี้จะถูกเรียกใช้งานเพียงครั้งเดียวเท่านั้น
    @PostConstruct
    public void loadData() {
        students = new ArrayList<Student>();
        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));
    }

    // define endpoint for /student return list of student
    @GetMapping("/students")
    public List<Student> getStudent() {
        return students;
    }
}
