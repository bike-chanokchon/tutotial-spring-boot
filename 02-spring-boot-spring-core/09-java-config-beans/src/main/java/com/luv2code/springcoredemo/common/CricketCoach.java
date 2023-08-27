package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    // // define our init method
    // @PostConstruct
    // public void doMyStartupStuff() {
    //     System.out.println("In doMyStartupStuff()" + getClass().getSimpleName());
    // }

    // // define our destroy method
    // @PreDestroy
    // public void doMyCleanupStuff() {
    //     System.out.println("Tn do myCleanupStuff()" + getClass().getSimpleName());
    // }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 5 minutes!!!";
    }
    
}
