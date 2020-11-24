package com.interview.questions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Questions Applications
 */
@SpringBootApplication
public class QuestionsApplication {

    /**
     * Question and Reply Application
     * @param args arguments to use when starting application
     */
    public static void main(String[] args) {
        SpringApplication.run(QuestionsApplication.class, args);
    }

}
