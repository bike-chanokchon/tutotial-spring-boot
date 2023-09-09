package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstrainValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    public String value() default "LUV";
    public String message() default "must be start with LUV";

    // Can group related constraints
    public Class<?>[] groups() default {};

    // Provide custom details about validation failure (severity level, error code etc)
    // ให้รายละเอียดเพิ่มเติมเกี่ยวกับข้อผิดพลาด
    public Class<? extends Payload>[] payload() default {};
}
