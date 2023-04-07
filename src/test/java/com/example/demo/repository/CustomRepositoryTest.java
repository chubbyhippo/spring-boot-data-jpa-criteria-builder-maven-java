package com.example.demo.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomRepositoryTest {
    @Autowired
    private CustomRepository repository;

    @Test
    void shouldGetStudentsByFirstname() {
        boolean thomas = repository.getStudentsByFirstname("Thomas").size() > 0;
        Assertions.assertThat(thomas).isTrue();
    }
}