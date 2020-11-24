package com.interview.questions.service;

import com.interview.questions.dao.FullQuestionResponse;
import com.interview.questions.dao.QuestionReplyResponse;
import com.interview.questions.entity.Question;
import com.interview.questions.exception.RecordNotFoundException;
import com.interview.questions.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class QuestionServiceTest {

    @InjectMocks
    private QuestionService questionService;

    @Mock
    private QuestionRepository questionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        questionService = new QuestionService(questionRepository);
    }

    @Test
    void getAllQuestions() {
        List<Question> questions = new ArrayList<>();

        Question question = new Question();
        question.setAuthor("Test");
        question.setMessage("Test Message");
        questions.add(question);

        when(questionRepository.findAll()).thenReturn(questions);
        List<FullQuestionResponse> result = questionService.getAllQuestions();

        assertEquals(result.get(0).getAuthor(), question.getAuthor());
        assertEquals(result.get(0).getMessage(), question.getMessage());
    }

    @Test
    void getQuestionById() throws RecordNotFoundException {
        Question question = new Question();
        question.setId(1L);
        question.setAuthor("Test");
        question.setMessage("Test Message");

        when(questionRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(question));
        QuestionReplyResponse result = questionService.getQuestionById(1L);

        assertEquals(result.getId(), 1L);
    }

    @Test
    void getQuestionByIdRecordNotFound() throws RecordNotFoundException {
        Exception exception = assertThrows(RecordNotFoundException.class, () -> {
            QuestionReplyResponse result = questionService.getQuestionById(-1L);
        });

        assertEquals(exception.getMessage(), "No question record exist for given id");
    }

    @Test
    void createQuestion() {
        Question question = new Question();
        question.setAuthor("Test");
        question.setMessage("Test Message");

        when(questionRepository.save(any(Question.class))).thenReturn(question);
        FullQuestionResponse result = questionService.createQuestion(question);

        assertEquals(result.getAuthor(), question.getAuthor());
        assertEquals(result.getMessage(), question.getMessage());
    }
}