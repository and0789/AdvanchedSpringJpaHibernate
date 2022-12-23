package com.itc.advancedjpahibernate.repository;

import com.itc.advancedjpahibernate.AdvancedJpaHibernateApplication;
import com.itc.advancedjpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AdvancedJpaHibernateApplication.class)
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    void findById_basic() {

        Course course = repository.findById(10001L);
        assertEquals("JPA and Hibernate", course.getName());
    }
}
