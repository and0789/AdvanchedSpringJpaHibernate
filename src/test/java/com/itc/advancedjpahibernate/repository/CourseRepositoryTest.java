package com.itc.advancedjpahibernate.repository;

import com.itc.advancedjpahibernate.AdvancedJpaHibernateApplication;
import com.itc.advancedjpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
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

    @Test
    @DirtiesContext // untuk memastikan data sebenarnya tidak berubah
    void deleteById_basic() {
        repository.deleteById(10003L);
        assertNull(repository.findById(10003L));
    }

    @Test
    @DirtiesContext // untuk memastikan data sebenarnya tidak berubah
    void save_basic() {
        // get a course
        Course course = repository.findById(10001L);
        assertEquals("JPA and Hibernate", course.getName());

        // update detail
        course.setName("JPA and Hibernate - Update");
        repository.save(course);

        // check the value
        Course course1 = repository.findById(10001L);
        assertEquals("JPA and Hibernate - Update", course1.getName());
    }

    @Test
    @DirtiesContext
    void playWithEntityManager_basic() {
        repository.playWithEntityManager();
    }
}
