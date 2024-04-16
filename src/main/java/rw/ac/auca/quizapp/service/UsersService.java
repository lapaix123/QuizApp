package rw.ac.auca.quizapp.service;

import rw.ac.auca.quizapp.model.Users;

import java.util.List;

public interface UsersService {
    Users newUsers(Users users);
    Users login(Users users);
    List<Users> usersList();

}
