package com.interview.questions.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * Question Entity
 */
@Data
@Entity
@Table(name = "TBL_QUESTIONS")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questions_seq_gen")
    @SequenceGenerator(name = "questions_seq_gen", sequenceName = "seq_questions")
    private Long id;

    @Column(name = "author")
    @NotBlank
    private String author;

    @Column(name = "message")
    @NotBlank
    private String message;

    @OneToMany(mappedBy = "questionId")
    private List<Reply> replies = new ArrayList<>();

    @Override
    public String toString() {
        return "QuestionEntity [id=" + id + ", author=" + author + ", message=" + message + "]";
    }
}