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
    public List<Result> getResultList() {
        return dao.findAll();
    }
}
