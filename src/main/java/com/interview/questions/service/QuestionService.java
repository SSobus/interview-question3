package com.interview.questions.service;

import com.interview.questions.dao.FullQuestionResponse;
import com.interview.questions.dao.QuestionReplyResponse;
import com.interview.questions.entity.Question;
import com.interview.questions.exception.RecordNotFoundException;
import com.interview.questions.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Question Service Class
 */
@Service
public class QuestionService {

    QuestionRepository repository;

    /**
     * Contructor
     * @param repository {@link com.interview.questions.repository.QuestionRepository}
     */
    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    /**
     * Get a list of all questions
     * @return {@link com.interview.questions.dao.FullQuestionResponse}
     */
    public List<FullQuestionResponse> getAllQuestions() {
        List<FullQuestionResponse> questionsList = repository.findAll().stream().map(FullQuestionResponse::new).collect(toList());
        return questionsList;
    }

    /**
     * Service to get a question by id
     * @param id Id of the question
     * @return {@link com.interview.questions.dao.QuestionReplyResponse}
     * @throws RecordNotFoundException Thrown if question ID does not exist
     */
    public QuestionReplyResponse getQuestionById(Long id) throws RecordNotFoundException {
        Optional<Question> question = repository.findById(id);

        if (question.isPresent()) {
            QuestionReplyResponse response = new QuestionReplyResponse(question.get());
            return response;
        } else {
            throw new RecordNotFoundException("No question record exist for given id");
        }
    }

    /**
     * Service to create a question
     * @param question {@link com.interview.questions.entity.Question}
     * @return {@link com.interview.questions.dao.FullQuestionResponse}
     */
    public FullQuestionResponse createQuestion(Question question) {
        Question newEntity = new Question();

        newEntity.setAuthor(question.getAuthor());
        newEntity.setMessage(question.getMessage());

        newEntity = repository.save(newEntity);

        FullQuestionResponse response = new FullQuestionResponse(newEntity);

        return response;
    }


}
