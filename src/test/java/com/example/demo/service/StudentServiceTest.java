package com.example.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Test
    void shouldGetStudentsByFirstname() {
        boolean thomas = (long) service.getStudentsByFirstname("Thomas").size() > 0;
        Assertions.assertThat(thomas).isTrue();
    }

}