package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Test08JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Test08JpaApplication.class, args);
    }

}
