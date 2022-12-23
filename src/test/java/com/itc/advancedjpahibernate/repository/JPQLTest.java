package com.itc.advancedjpahibernate.repository;

import com.itc.advancedjpahibernate.AdvancedJpaHibernateApplication;
import com.itc.advancedjpahibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(classes = AdvancedJpaHibernateApplication.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    void jpql_basic() {
        Query query = entityManager.createQuery("SELECT c FROM Course c");
        List resultList = query.getResultList();

        logger.info("SELECT c FROM Course c -> {} ", resultList);
    }


    @Test
    void jpql_typed() {
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("SELECT c FROM Course c -> {} ", resultList);
    }

    @Test
    void jpql_where() {
        TypedQuery<Course> query =
                entityManager.createQuery(
                        "SELECT C FROM Course C WHERE name LIKE '%Basic%'",
                        Course.class
                );

        List<Course> resultList = query.getResultList();

        logger.info("SELECT C FROM Course C WHERE name LIKE '%Basic' -> {} ", resultList);
    }
}
