package rw.ac.auca.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.auca.quizapp.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}