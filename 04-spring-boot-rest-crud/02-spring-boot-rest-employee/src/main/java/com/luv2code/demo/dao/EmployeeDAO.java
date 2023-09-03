package com.luv2code.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.demo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAO implements IEmployeeDAO {
    private EntityManager entityManager;

    // @Autowired
    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = this.entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = this.entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee entity) {
        /*
         * 
         * ถ้า id เป็น 0 จะเป็นการ insert/save
         * ถ้า id ไม่เป็น 0 จะเป็นการ update
         * 
         */
        Employee employee = this.entityManager.merge(entity);
        return employee; // return data updated or inserted from db
    }

    @Override
    public void deleteById(int id) {
        Employee employee = this.findById(id);

        this.entityManager.remove(employee);
    }
}
