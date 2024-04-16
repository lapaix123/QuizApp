package rw.ac.auca.quizapp.service;

import rw.ac.auca.quizapp.model.Result;

import java.util.List;

public interface ResultService {
Result newResult(Result result);
List<Result> getResultList();
}
