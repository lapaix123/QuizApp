package rw.ac.auca.quizapp.service;

import rw.ac.auca.quizapp.model.Question;

import java.util.List;

public interface QuestionService {
    Question newQuestion(Question question);
    Question updateQuestion(Question question);
    Question deleteQuestion(int questionId);
    Question getQuestionById(int questionId);
    List<Question> getQuestionsByQuizId(int quizId);
    List<Question> getAllQuestions();
}
