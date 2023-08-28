package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student", Student.class);

        // return query result
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        query.setParameter("theData", lastName);

        // return query result
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
       this.entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        // retrieve the student
        Student student = this.entityManager.find(Student.class, id);

        // delete the student
        this.entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowDeleted = this.entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowDeleted;
    }
}
