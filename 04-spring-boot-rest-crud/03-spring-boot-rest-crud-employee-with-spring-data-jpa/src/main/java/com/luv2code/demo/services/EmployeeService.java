package com.luv2code.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luv2code.demo.dao.IEmployeeRepository;
import com.luv2code.demo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = this.employeeRepository.findById(id);

        // return true if data not null, if data is null will return false
        if (!employee.isPresent()) 
            throw new RuntimeException("Did not find employee id - " + id);    

        return employee.get();
    }

    @Transactional
    @Override
    public Employee save(Employee entity) {
        return this.employeeRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        this.employeeRepository.deleteById(id);
    }
    
}
