package com.interview.questions.service;

import com.interview.questions.dao.CreateReplyRequest;
import com.interview.questions.dao.QuestionReplyResponse;
import com.interview.questions.entity.Question;
import com.interview.questions.entity.Reply;
import com.interview.questions.exception.RecordNotFoundException;
import com.interview.questions.repository.ReplyRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ReplyServiceTest {

    @InjectMocks
    ReplyService replyService;

    @Mock
    ReplyRepository replyRepository;
    @Mock
    QuestionService questionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        replyService = new ReplyService(replyRepository, questionService);
    }


    @Test
    void createReply() throws RecordNotFoundException {
        Reply reply = new Reply();
        reply.setAuthor("Test");
        reply.setMessage("Test Message");
        reply.setQuestionId(9L);

        CreateReplyRequest createReplyRequest = new CreateReplyRequest();
        reply.setAuthor("Test");
        reply.setMessage("Test Message");

        Question question = new Question();
        question.setAuthor("Test Question");
        question.setMessage("Test Question Message");
        question.setId(9L);

        QuestionReplyResponse questionReplyResponse = new QuestionReplyResponse(question);

        when(replyRepository.save(any(Reply.class))).thenReturn(reply);
        when(questionService.getQuestionById(any(Long.class))).thenReturn(questionReplyResponse);

        Reply result = replyService.createReply(9L, createReplyRequest);

        assertEquals(result.getAuthor(), reply.getAuthor());
        assertEquals(result.getMessage(), reply.getMessage());
        assertEquals(result.getQuestionId(), 9L);
    }

    @Test
    void getQuestionById() throws RecordNotFoundException {
        Exception exception = assertThrows(RecordNotFoundException.class, () -> {
            CreateReplyRequest createReplyRequest = new CreateReplyRequest();
            createReplyRequest.setAuthor("Test");
            createReplyRequest.setMessage("Test Message");

            Reply result = replyService.createReply(-1L, createReplyRequest);
        });

        assertEquals(exception.getMessage(), "Could not find question");
    }
}