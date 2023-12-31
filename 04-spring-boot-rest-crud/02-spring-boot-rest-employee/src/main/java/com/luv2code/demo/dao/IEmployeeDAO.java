package com.luv2code.demo.dao;

import java.util.List;

import com.luv2code.demo.entity.Employee;

public interface IEmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee entity);
    void deleteById(int id);
}
