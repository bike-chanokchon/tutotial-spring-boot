package com.luv2code.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.demo.entity.Employee;

@RepositoryRestResource(path = "members")
// JpaReository<Entity, Primary>
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it no need to write any code.
}
