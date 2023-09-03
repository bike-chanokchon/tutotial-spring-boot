package com.luv2code.demo.services;

import java.util.List;

import com.luv2code.demo.entity.Employee;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee entity);
    void deleteById(int id);
}
