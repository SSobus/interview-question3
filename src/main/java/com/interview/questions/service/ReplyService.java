package com.interview.questions.service;

import com.interview.questions.dao.BasicQuestionResponse;
import com.interview.questions.dao.CreateReplyRequest;
import com.interview.questions.entity.Question;
import com.interview.questions.entity.Reply;
import com.interview.questions.exception.RecordNotFoundException;
import com.interview.questions.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReplyService {

    ReplyRepository replyRepository;
    QuestionService questionService;

    public ReplyService(ReplyRepository replyRepository, QuestionService questionService) {
        this.replyRepository = replyRepository;
        this.questionService = questionService;
    }

    public Reply createReply(Long questionId, CreateReplyRequest entity) throws RecordNotFoundException {
        Optional<BasicQuestionResponse> question = Optional.ofNullable(questionService.getQuestionById(questionId));

        //check to make sure the question is exists before adding a reply to it
        if (question.isPresent()) {
            Reply newEntity = new Reply();
            newEntity.setAuthor(entity.getAuthor());
            newEntity.setMessage(entity.getMessage());
            newEntity.setQuestionId(questionId);

            newEntity = replyRepository.save(newEntity);

            return newEntity;
        } else {
            throw new RecordNotFoundException("Could not find question");
        }
    }

}
