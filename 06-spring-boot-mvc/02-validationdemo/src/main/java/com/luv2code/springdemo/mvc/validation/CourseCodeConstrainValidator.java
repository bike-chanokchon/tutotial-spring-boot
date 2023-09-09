package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    // จะถูกเรียกเมื่อ validator ถูกสร้างขึ้นเพื่อกำหนดค่าเริ่มต้นให้กับ validator
    @Override
    public void initialize(CourseCode courseCode) {
        this.coursePrefix = courseCode.value();
    }

    // spring MVC จะเรียกใช้ isValid() เอง
    // isValid(ข้อมูลที่ผู้ใช้ส่งมา, ใช้เพื่อเพิ่มข้อความข้อผิดพลาด)
    @Override
    public boolean isValid(String code, ConstraintValidatorContext arg1) {
        boolean result;

        if (code != null) {
            result = code.startsWith(coursePrefix);
        } else {
            result = true;
        }

        return result;
    }
    
}
