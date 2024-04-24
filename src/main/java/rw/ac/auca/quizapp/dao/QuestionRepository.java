package rw.ac.auca.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.ac.auca.quizapp.model.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query("SELECT q FROM Question q JOIN q.quiz quiz WHERE quiz.id = :quizId")
    List<Question> findByQuizId(int quizId);

}