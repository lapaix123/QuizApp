package rw.ac.auca.quizapp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.auca.quizapp.dao.QuestionRepository;
import rw.ac.auca.quizapp.model.Question;
import rw.ac.auca.quizapp.service.QuestionService;

import java.util.List;

@Service
public class QuestionImp implements QuestionService {
    @Autowired
    private QuestionRepository dao;
    @Override
    public Question newQuestion(Question question) {
        return dao.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        Question question1=dao.findById(question.getId()).orElse(null);
        if(question1 != null){
            question1.setQuestion(question.getQuestion());
            question1.setCorrect(question.getCorrect());
            question1.setOption1(question.getOption1());
            question1.setOption2(question.getOption2());
            question1.setOption3(question.getOption3());
            question1.setOption4(question.getOption4());
            question1.setQuiz(question.getQuiz());
            return dao.save(question1);
        }
        return null;
    }

    @Override
    public Question deleteQuestion(int questionId) {
        Question question=dao.findById(questionId).orElse(null);
        if(question!=null){
            dao.delete(question);
            return question;
        }
        return null;
    }

    @Override
    public Question getQuestionById(int questionId) {
        return dao.findById(questionId).orElse(null);
    }

    @Override
    public List<Question> getQuestionsByQuizId(int quizId) {
        return dao.findByQuizId(quizId);
    }

    @Override
    public List<Question> getAllQuestions() {
        return dao.findAll();
    }
}
