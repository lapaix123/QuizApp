package rw.ac.auca.quizapp.service;

import rw.ac.auca.quizapp.model.Result;

import java.util.List;

public interface ResultService {
Result newResult(Result result);

    Result updateResult(Result result);

    Result deleteResult(int resultId);

    Result getResultById(int resultId);

    List<Result> getAllResults();

    Result getResultByQuizId(int quizId);
}
