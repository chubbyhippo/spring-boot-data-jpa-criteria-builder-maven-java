package com.example.demo.service;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

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
