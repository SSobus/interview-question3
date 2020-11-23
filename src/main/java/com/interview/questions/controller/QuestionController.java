package com.interview.questions.controller;

import com.interview.questions.dao.BasicQuestionResponse;
import com.interview.questions.dao.CreateReplyRequest;
import com.interview.questions.dao.FullQuestionResponse;
import com.interview.questions.dao.QuestionReplyResponse;
import com.interview.questions.entity.Question;
import com.interview.questions.entity.Reply;
import com.interview.questions.exception.RecordNotFoundException;
import com.interview.questions.service.QuestionService;
import com.interview.questions.service.ReplyService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    QuestionService questionService;
    ReplyService replyService;

    public QuestionController(QuestionService questionService, ReplyService replyService) {
        this.questionService = questionService;
        this.replyService = replyService;
    }

    /**
     * GET - List of questions
     * @return List of {@link com.interview.questions.entity.Question}
     */
    @GetMapping
    public ResponseEntity<List<FullQuestionResponse>> getAllQuestions() {
        List<FullQuestionResponse> list = questionService.getAllQuestions();

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * GET - Question by its ID
     * @param id The ID of the question
     * @return {@link com.interview.questions.entity.Question}
     * @throws RecordNotFoundException Could not find question
     */
    @GetMapping("/{id}")
    public ResponseEntity<QuestionReplyResponse> getQuestionById(@PathVariable Long id)
            throws RecordNotFoundException {
        QuestionReplyResponse entity = questionService.getQuestionById(id);

        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * POST - Create a question
     * @param question {@link com.interview.questions.entity.Question}
     * @return {@link BasicQuestionResponse}
     */
    @PostMapping
    public ResponseEntity<FullQuestionResponse> createQuestion(@RequestBody @Valid Question question) {
        FullQuestionResponse created = questionService.createQuestion(question);
        return new ResponseEntity<>(created, new HttpHeaders(), HttpStatus.CREATED);
    }

    /**
     * Create a reply to a question
     * @param questionId Long
     * @param reply {@link com.interview.questions.dao.CreateReplyRequest}
     * @return {@link com.interview.questions.entity.Question}
     * @throws RecordNotFoundException Could not find the question
     */
    @PutMapping("/{questionId}/reply")
    public ResponseEntity<Reply> createReply(@PathVariable Long questionId, @RequestBody CreateReplyRequest createReplyRequest) throws RecordNotFoundException {
        Reply created = replyService.createReply(questionId, createReplyRequest);
        return new ResponseEntity<>(created, new HttpHeaders(), HttpStatus.CREATED);
    }


}
