package com.interview.questions.service;

import com.interview.questions.dao.BasicQuestionResponse;
import com.interview.questions.dao.FullQuestionResponse;
import com.interview.questions.dao.QuestionReplyResponse;
import com.interview.questions.entity.Question;
import com.interview.questions.exception.RecordNotFoundException;
import com.interview.questions.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class QuestionService {

    QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public List<FullQuestionResponse> getAllQuestions() {
        List<FullQuestionResponse> questionsList = repository.findAll().stream().map(FullQuestionResponse::new).collect(toList());

//        if (questionsList.size() > 0) {
            return questionsList;
//        } else {
//            return new ArrayList<>();
//        }
    }

    public QuestionReplyResponse getQuestionById(Long id) throws RecordNotFoundException {
        Optional<Question> question = repository.findById(id);

        if (question.isPresent()) {
            QuestionReplyResponse response = new QuestionReplyResponse(question.get());
            return response;
        } else {
            throw new RecordNotFoundException("No question record exist for given id");
        }
    }

    public FullQuestionResponse createQuestion(Question entity) {
        Question newEntity = new Question();

        newEntity.setAuthor(entity.getAuthor());
        newEntity.setMessage(entity.getMessage());

        newEntity = repository.save(newEntity);

        FullQuestionResponse response = new FullQuestionResponse(newEntity);

        return response;
    }


}
