package com.luv2code.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository // ทำให้ Spring scan เจอและสามารถแปรงข้อผิดพลาด JDBC Exceptions
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    @Transactional // เพื่มเมื่อมีการบักทึกข้อมูลหรือจัดเก็บวัตถุลงในฐานข้อมูล
    public void save(Student student) {
        this.entityManager.persist(student); // save data to database
    }

    @Override
    public Student findById(int id) {
        // entity class, primary key
        return this.entityManager.find(Student.class, id);
    }
}
