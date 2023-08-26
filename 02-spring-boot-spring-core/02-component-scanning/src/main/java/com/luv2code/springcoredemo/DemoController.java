package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency 
    private Coach myCoach;

    // define a constructor for dependency injection
    @Autowired // ถ้าหากมีแค่ 1 constructor จะใส่หรือไม่ใส่ก็ได้
    public DemoController(Coach theCoach) {
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }
}
