package rw.ac.auca.quizapp.service;

import rw.ac.auca.quizapp.model.Users;

import java.util.List;

public interface UsersService {
    Users newUsers(Users users);
    Users getUserByEmail(String email,String password);
    List<Users> usersList();

}
