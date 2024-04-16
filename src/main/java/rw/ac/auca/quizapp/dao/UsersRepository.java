package rw.ac.auca.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.auca.quizapp.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}