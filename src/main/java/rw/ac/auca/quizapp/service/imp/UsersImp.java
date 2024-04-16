package rw.ac.auca.quizapp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.auca.quizapp.dao.UsersRepository;
import rw.ac.auca.quizapp.model.Users;
import rw.ac.auca.quizapp.service.UsersService;

import java.util.List;

@Service
public class UsersImp implements UsersService {
    @Autowired
    private UsersRepository dao;
    @Override
    public Users newUsers(Users users) {
        return dao.save(users);
    }

    @Override
    public Users login(Users users) {
        return null;
    }

    @Override
    public List<Users> usersList() {
        return dao.findAll();
    }
}
