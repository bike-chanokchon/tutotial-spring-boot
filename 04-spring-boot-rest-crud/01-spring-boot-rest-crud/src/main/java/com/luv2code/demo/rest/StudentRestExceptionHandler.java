package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // เป็น controller ตัวกลางที่ใช้จัดการกับข้อผิดพลาดที่เกิดขึั้นใน Spring Framework
public class StudentRestExceptionHandler {
    // add exception handing code

    // Add an exception handler user using @ExceptionHandler
    /*
        - ResponseEntity<[Type of response body]>
        - [Exception type] exc
    */ 
    @ExceptionHandler // เป็น annotation ที่ใช้ในการกำหนดเมธอดที่จะถูกเรียกเมื่อเกิดข้อผิดพลาด (exception) ขึ้นในแอพพลิเคชัน Spring Boot
    public ResponseEntity<StudentErrorResponse> handlerException(StudentNotFoundException exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        // (body, status code)
        return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
    }

    // catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlerException(Exception exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        // (body, status code)
        return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }
}
