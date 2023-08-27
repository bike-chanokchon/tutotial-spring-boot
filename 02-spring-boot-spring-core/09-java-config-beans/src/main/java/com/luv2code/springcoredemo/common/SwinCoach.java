package com.luv2code.springcoredemo.common;

public class SwinCoach implements Coach {

    public SwinCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as warm up";
    }
    
}
