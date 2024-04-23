package rw.ac.auca.quizapp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rw.ac.auca.quizapp.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query("from Users where email=:email and password=:password")
    Users findByEmailAndPassword(@Param("email") String email,@Param("password") String password);
}