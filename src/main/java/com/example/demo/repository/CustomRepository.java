package com.example.demo.repository;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomRepository {
    private final EntityManager entityManager;

    public List<Student> getStudentsByFirstname(String firstname) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Student.class);
        var studentRoot = criteriaQuery.from(Student.class);
        var hasFirstname = criteriaBuilder.equal(studentRoot.get("firstname"), firstname);
        criteriaQuery.where(hasFirstname);

        var query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();


    }
}
