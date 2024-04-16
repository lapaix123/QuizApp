package rw.ac.auca.quizapp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.auca.quizapp.dao.QuestionRepository;
import rw.ac.auca.quizapp.model.Question;
import rw.ac.auca.quizapp.service.QuestionService;
@Service
public class QuestionImp implements QuestionService {
    @Autowired
    private QuestionRepository dao;
    @Override
    public Question newQuestion(Question question) {
        return dao.save(question);
    }
}
