package com.interview.questions.dao;

import com.interview.questions.entity.Question;
import lombok.Data;

/**
 * Question response with reply count
 */
@Data
public class FullQuestionResponse extends BasicQuestionResponse {
    private Integer replies;

    /**
     * Response used containing the number of replies
     * @param question {@link com.interview.questions.entity.Question}
     */
    public FullQuestionResponse(Question question) {
        super(question);
        replies = question.getReplies().size();
    }
}
