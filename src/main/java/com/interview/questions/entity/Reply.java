package com.interview.questions.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Reply Entity
 */
@Data
@Entity
@Table(name = "TBL_REPLIES")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_seq_gen")
    @SequenceGenerator(name = "reply_seq_gen", sequenceName = "seq_reply")
    private Long Id;

    @Column(name = "questionId")
    private Long questionId;

    @Column(name = "author")
    @NotBlank
    private String author;

    @Column(name = "message")
    @NotBlank
    private String message;
}
