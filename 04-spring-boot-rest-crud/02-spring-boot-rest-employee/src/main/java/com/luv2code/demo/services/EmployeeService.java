package com.luv2code.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.demo.dao.IEmployeeDAO;
import com.luv2code.demo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService implements IEmployeeService {
    private IEmployeeDAO employeeDAO;

    public EmployeeService(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee entity) {
        return this.employeeDAO.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        this.employeeDAO.deleteById(id);
    }
    
}
