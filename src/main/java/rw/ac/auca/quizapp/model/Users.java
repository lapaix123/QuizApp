package rw.ac.auca.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="email")
    private String email;

    @Column(name="firstName")
    private String firstName;


    @Column(name="password")
    private String password;

    @Column(name = "role")
    private String role;
}
