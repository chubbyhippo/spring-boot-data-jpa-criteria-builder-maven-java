package com.example.demo.config;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final StudentRepository studentRepository;

    @Bean
    public ApplicationRunner loader() {
        return args -> {
            studentRepository.save(new Student(null, "Thomas", "Eddison", null));

        };
    }
}
