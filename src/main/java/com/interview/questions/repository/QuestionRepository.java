package com.interview.questions.repository;


import com.interview.questions.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Question Repository extend JpaRepository
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
