package com.luv2code.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entity.Employee;
import com.luv2code.demo.services.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private IEmployeeService employeeService;

    public EmployeeRestController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> findAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = this.employeeService.findById(employeeId);

        if (employee == null) 
            throw new RuntimeException("Employee id not found - " + employeeId);

        return employee;
    }

    // @RequestBody - ดึงข้อมูลจาก body
    @PostMapping("")
    public Employee createEmployee(@RequestBody Employee employee) {
        // also just in case they pass an id in JSON... set id to 0
        // this is to force a save new item... instead of update
        employee.setId(0);

        Employee newEmployee = this.employeeService.save(employee);

        return newEmployee;
    }

    @PutMapping("{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int employeeId) {
        employee.setId(employeeId);
        Employee updatedEmployee = this.employeeService.save(employee);
        return updatedEmployee;
    }

    @DeleteMapping("{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = this.employeeService.findById(employeeId);

        if (employee == null) 
            throw new RuntimeException("Employee id nit found - " + employeeId);

        this.employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
