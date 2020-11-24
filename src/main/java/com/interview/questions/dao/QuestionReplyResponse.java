package com.interview.questions.dao;

import com.interview.questions.entity.Question;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Question response with Reply list
 */
@Data
public class QuestionReplyResponse extends BasicQuestionResponse {
    private List<BasicReplyResponse> replies;

    /**
     * Response used containing replies to the question
     * @param question {@link com.interview.questions.entity.Question}
     */
    public QuestionReplyResponse(Question question) {
        super(question);
        replies = question.getReplies().stream().map(BasicReplyResponse::new).collect(toList());
    }

}
