package rw.ac.auca.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rw.ac.auca.quizapp.model.Quiz;
import rw.ac.auca.quizapp.service.QuizService;

@Controller
public class QuizController {
   @Autowired
    private QuizService quizService;


    @GetMapping("/quiz")
    public String Quiz(Model model) {
        model.addAttribute("quiz",new Quiz());
        return "Quiz";
    }
    @PostMapping("/saveQuiz")
    public String saveQuiz(@ModelAttribute("quiz") Quiz quiz){
        quizService.newQuiz(quiz);
        return "redirect:/teacherDashboard";
    }
}
