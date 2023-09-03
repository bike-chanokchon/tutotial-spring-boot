package com.luv2code.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.dao.IEmployeeDAO;
import com.luv2code.demo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private IEmployeeDAO employeeDAO;

    public EmployeeRestController(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }
}
