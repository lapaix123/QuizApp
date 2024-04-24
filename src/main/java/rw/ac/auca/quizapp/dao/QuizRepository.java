package rw.ac.auca.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.ac.auca.quizapp.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    @Query("SELECT DISTINCT q FROM Quiz q LEFT JOIN FETCH q.results")
    Quiz findAllWithResult();
}