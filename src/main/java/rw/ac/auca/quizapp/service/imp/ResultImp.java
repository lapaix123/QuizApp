package rw.ac.auca.quizapp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.auca.quizapp.dao.ResultRepository;
import rw.ac.auca.quizapp.model.Result;
import rw.ac.auca.quizapp.service.ResultService;

import java.util.List;
@Service
public class ResultImp implements ResultService {
    @Autowired
    private ResultRepository dao;
    @Override
    public Result newResult(Result result) {
        return dao.save(result);
    }

    @Override
    public Result updateResult(Result result) {
        Result result1=dao.findById(result.getId()).orElse(null);
        if(result1!= null){
            result1.setQuiz(result.getQuiz());
            result1.setScore(result.getScore());
            return dao.save(result1);
        }
        return null;
    }

    @Override
    public Result deleteResult(int resultId) {
        Result result1=dao.findById(resultId).orElse(null);
        if(result1!=null){
            dao.delete(result1);
            return result1;
        }
        return null;
    }

    @Override
    public Result getResultById(int resultId) {

        return dao.findById(resultId).orElse(null);
    }

    @Override
    public List<Result> getAllResults() {
        return dao.findAll();
    }

    @Override
    public Result getResultByQuizId(int quizId) {
        return dao.findByQuizId(quizId);
    }

}
