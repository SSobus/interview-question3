package com.interview.questions.service;

import com.interview.questions.dao.BasicQuestionResponse;
import com.interview.questions.dao.CreateReplyRequest;
import com.interview.questions.entity.Question;
import com.interview.questions.entity.Reply;
import com.interview.questions.exception.RecordNotFoundException;
import com.interview.questions.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Reply Service Class
 */
@Service
public class ReplyService {

    ReplyRepository replyRepository;
    QuestionService questionService;

    /**
     * Contructor
     * @param replyRepository Autowired {@link com.interview.questions.repository.ReplyRepository}
     * @param questionService Autowired {@link com.interview.questions.service.QuestionService}
     */
    public ReplyService(ReplyRepository replyRepository, QuestionService questionService) {
        this.replyRepository = replyRepository;
        this.questionService = questionService;
    }

    /**
     * Service to create a reply for a question
     * @param questionId The ID of the question
     * @param createReplyRequest {@link com.interview.questions.dao.CreateReplyRequest}
     * @return {@link com.interview.questions.entity.Reply}
     * @throws RecordNotFoundException Thrown if the question with the ID does not exist
     */
    public Reply createReply(Long questionId, CreateReplyRequest createReplyRequest) throws RecordNotFoundException {
        Optional<BasicQuestionResponse> question = Optional.ofNullable(questionService.getQuestionById(questionId));

        //check to make sure the question is exists before adding a reply to it
        if (question.isPresent()) {
            Reply newEntity = new Reply();
            newEntity.setAuthor(createReplyRequest.getAuthor());
            newEntity.setMessage(createReplyRequest.getMessage());
            newEntity.setQuestionId(questionId);

            newEntity = replyRepository.save(newEntity);

            return newEntity;
        } else {
            throw new RecordNotFoundException("Could not find question");
        }
    }

}
