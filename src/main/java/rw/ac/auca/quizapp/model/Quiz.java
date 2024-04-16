package rw.ac.auca.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Column(name = "timer_seconds")
    private Integer timerSeconds;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER)
    private List<Result> results;

}
