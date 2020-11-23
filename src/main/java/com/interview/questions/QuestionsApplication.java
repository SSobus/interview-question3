package com.interview.questions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class QuestionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionsApplication.class, args);
    }

}
