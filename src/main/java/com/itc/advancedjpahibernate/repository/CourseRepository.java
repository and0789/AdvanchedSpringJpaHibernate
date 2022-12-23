package com.itc.advancedjpahibernate.repository;

import com.itc.advancedjpahibernate.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public Course save (Course course) {
        if (course.getId() == null) {
            // insert
            entityManager.persist(course);
        } else {
            // update
            entityManager.merge(course);
        }
        return course;
    }
}
