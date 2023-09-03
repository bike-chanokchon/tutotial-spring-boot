package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // define endpoint of "/student/{studentId}" - return student at index of array
    // @PathVariable เป็นการดึงค่าจาก path variable โดยชื่อตัวแปรจะต้องตรงกัน
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // check the studentId again list size
        if ((studentId >= this.students.size()) || (studentId < 0)) {
            // custom class exception for student
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return this.students.get(studentId);
    }
}
