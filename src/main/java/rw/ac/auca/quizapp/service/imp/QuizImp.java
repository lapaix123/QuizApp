package rw.ac.auca.quizapp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.auca.quizapp.dao.QuizRepository;
import rw.ac.auca.quizapp.model.Quiz;
import rw.ac.auca.quizapp.service.QuizService;

import java.util.List;
@Service
public class QuizImp implements QuizService {
    @Autowired
    private QuizRepository dao;
    @Override
    public Quiz newQuiz(Quiz quiz) {
        return dao.save(quiz);
    }

    @Override
    public List<Quiz> listOfQuizzes() {
        return dao.findAll();
    }
}
