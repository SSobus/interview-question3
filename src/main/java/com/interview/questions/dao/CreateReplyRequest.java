package com.interview.questions.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * Create Reply Request
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateReplyRequest {

    private String author;
    private String message;

}
