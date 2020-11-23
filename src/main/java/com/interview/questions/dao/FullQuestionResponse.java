package com.interview.questions.dao;

import com.interview.questions.entity.Question;
import lombok.Data;

@Data
public class FullQuestionResponse extends BasicQuestionResponse {
    private Integer replies;

    public FullQuestionResponse(Question question) {
        super(question);
        replies = question.getReplies().size();
    }
}
