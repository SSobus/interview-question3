package com.interview.questions.dao;

import com.interview.questions.entity.Reply;
import lombok.Data;

/**
 * Basic Reply response
 */
@Data
public class BasicReplyResponse {

    private Long Id;
    private String author;
    private String message;

    /**
     * Basic reply response containing basic information
     * @param reply {@link com.interview.questions.entity.Reply}
     */
    public BasicReplyResponse(Reply reply){
        this.Id = reply.getId();
        this.author = reply.getAuthor();
        this.message = reply.getMessage();
    }

}
