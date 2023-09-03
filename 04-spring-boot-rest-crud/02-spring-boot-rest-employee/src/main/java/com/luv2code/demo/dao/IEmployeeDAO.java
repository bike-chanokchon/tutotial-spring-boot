package com.luv2code.demo.dao;

import java.util.List;

import com.luv2code.demo.entity.Employee;

public interface IEmployeeDAO {
    List<Employee> findAll();
}
