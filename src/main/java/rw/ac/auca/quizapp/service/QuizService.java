package rw.ac.auca.quizapp.service;

import rw.ac.auca.quizapp.model.Quiz;

import java.util.List;

public interface QuizService {
    Quiz newQuiz(Quiz quiz);
    List<Quiz> listOfQuizzes();
}
