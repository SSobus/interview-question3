package com.interview.questions.dao;

import com.interview.questions.entity.Question;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BasicQuestionResponse {

    private Long id;
    private String author;
    private String message;

    public BasicQuestionResponse(Question question){
        id = question.getId();
        author = question.getAuthor();
        message = question.getMessage();
    }
}
