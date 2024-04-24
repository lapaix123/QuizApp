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

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        Quiz quiz1=dao.findById(quiz.getId()).orElse(null);
        if(quiz1!=null){
            quiz1.setTitle(quiz.getTitle());
            quiz1.setTimerSeconds(quiz.getTimerSeconds());
            return dao.save(quiz1);
        }
        return null;
    }

    @Override
    public Quiz getQuizById(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Quiz deleteQuiz(int id) {
        Quiz quiz1=dao.findById(id).orElse(null);
        if(quiz1!=null){
            dao.delete(quiz1);
            return quiz1;
        }
        return null;
    }

    @Override
    public Quiz getQuizWithResults() {
        return dao.findAllWithResult();
    }
}
