package com.example.jobrecorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories("com.example.jobrecorder.repository")
@EntityScan("com.example.jobrecorder.entity")
public class JobRecorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobRecorderApplication.class, args);
    }

}