package rw.ac.auca.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.auca.quizapp.model.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {
}