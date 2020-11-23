package com.interview.questions.dao;

import com.interview.questions.entity.Reply;
import lombok.Data;

@Data
public class BasicReplyResponse {

    private Long Id;
    private String author;
    private String message;

    public BasicReplyResponse(Reply reply){
        this.Id = reply.getId();
        this.author = reply.getAuthor();
        this.message = reply.getMessage();
    }

}
