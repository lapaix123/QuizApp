package rw.ac.auca.quizapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rw.ac.auca.quizapp.model.Quiz;
import rw.ac.auca.quizapp.model.Users;
import rw.ac.auca.quizapp.service.QuizService;
import rw.ac.auca.quizapp.service.UsersService;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private QuizService quizService;
    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new Users());
        return "Signup"; // Thymeleaf template name
    }

    @PostMapping("/signup")
    public String signUpUser(@ModelAttribute("user") Users user) {
        usersService.newUsers(user);
        return "redirect:/login";
    }

    @GetMapping("/studentDashboard")
    public String showDashboard(Model model,HttpSession session) {
       Users logedInStudent=(Users) session.getAttribute("login");
       if(logedInStudent == null){
           return "redirect:/login";
       }
       model.addAttribute("logedinStudent", logedInStudent);
        return "studentDashboard";
    }
    @GetMapping("/teacherDashboard")
    public String showTeacherDashboard(Model model,HttpSession session ) {
        Users logedInTeacher=(Users) session.getAttribute("login");

        if(logedInTeacher== null){
            return "redirect:/login";
        }
        model.addAttribute("logedinStudent", logedInTeacher);
        model.addAttribute("quiz",new Quiz());
        model.addAttribute("quizzes",quizService.listOfQuizzes());
        return "teacherDashboard";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new Users());
        return "Login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") Users user, HttpSession session) {
        Users login=usersService.getUserByEmail(user.getEmail(),user.getPassword());
        if(login == null){
            return "redirect:/login";
        }else{
            session.setAttribute("login",login);
            if(login.getRole().equals("Student")){
                return "redirect:/studentDashboard";
            }
            else if(login.getRole().equals("Teacher")){
                return "redirect:/teacherDashboard";
            }else {
                return "redirect:/login";
            }
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
