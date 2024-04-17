package rw.ac.auca.quizapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PageController {
    @GetMapping("/")
    public String home() {
        return "index"; // This will resolve to /WEB-INF/views/home.jsp
    }
    @GetMapping("/editQuiz")
    public String editQuiz() {
        return "EditQuiz"; // This will resolve to /WEB-INF/views/home.jsp
    }
    @GetMapping("/question")
    public String question() {
        return "Question"; // This will resolve to /WEB-INF/views/home.jsp
    }
    @GetMapping("/login")
    public String login() {
        return "Login"; // This will resolve to /WEB-INF/views/home.jsp
    }
    @GetMapping("/quiz")
    public String Quiz() {
        return "quiz"; // This will resolve to /WEB-INF/views/home.jsp
    }
    @GetMapping("/showQuiz")
    public String showQuiz() {
        return "showQuiz"; // This will resolve to /WEB-INF/views/home.jsp
    }
    @GetMapping("/showScore")
    public String showScore() {
        return "ShowScore"; // This will resolve to /WEB-INF/views/home.jsp
    }
    @GetMapping("/signup")
    public String signup() {
        return "Signup"; // This will resolve to /WEB-INF/views/home.jsp
    }
    @GetMapping("/studentDashboard")
    public String studentDashboard() {
        return "studentDashboard"; // This will resolve to /WEB-INF/views/home.jsp
    }
    @GetMapping("/teacherDashboard")
    public String teacherDashboard() {
        return "teacherDashboard"; // This will resolve to /WEB-INF/views/home.jsp
    }

}
