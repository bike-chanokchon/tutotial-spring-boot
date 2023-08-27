package com.luv2code.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springcoredemo.common.Coach;

@RestController
public class DemoController {
    // define a private field for the dependency 
    private Coach myCoach;
    private Coach anotherCoach;

    // define a constructor for dependency injection
    //@Qualifier("trackCoach") 
    @Autowired // ถ้าหากมีแค่ 1 constructor จะใส่หรือไม่ใส่ก็ได้
    public DemoController(@Qualifier("cricketCoach") Coach theCoach, 
                          @Qualifier("cricketCoach") Coach theAnotherCoach) {
        this.myCoach = theCoach;
        this.anotherCoach = theAnotherCoach;
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
