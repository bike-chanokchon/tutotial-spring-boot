package com.luv2code.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.demo.entity.Employee;

// JpaReository<Entity, Primary>
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it no need to write any code.
}
