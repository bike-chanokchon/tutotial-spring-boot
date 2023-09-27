package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        // insert data
        this.entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return this.entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = this.findInstructorById(id);

        if (instructor != null) {
            this.entityManager.remove(instructor);
        }
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return this.entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = this.findInstructorDetailById(id);
        
        // remove the associated object reference
        // break bi-directional link
        instructorDetail.getInstructor().setInstructorDetail(null);

        if (instructorDetail != null) {
            this.entityManager.remove(instructorDetail);
        }
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        // create query
        TypedQuery<Course> query = this.entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        
        query.setParameter("data", id);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;
    }
}
