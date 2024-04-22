package rw.ac.auca.quizapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rw.ac.auca.quizapp.model.Users;
import rw.ac.auca.quizapp.service.UsersService;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new Users());
        return "Signup"; // Thymeleaf template name
    }

    @PostMapping("/signup")
    public String signUpUser(@ModelAttribute("user") Users user) {
        usersService.newUsers(user);
        return "redirect:/login"; // Redirect to login page after signup
    }

    @GetMapping("/studentDashboard")
    public String showDashboard(Model model,HttpSession session) {
       Users logedInStudent=(Users) session.getAttribute("login");
       if(logedInStudent == null){
           return "redirect:/login"; // Redirect to login page after
       }
       model.addAttribute("logedinStudent", logedInStudent);
        return "studentDashboard"; // Thymeleaf template name
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new Users());
        return "Login"; // Thymeleaf template name
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") Users user, HttpSession session) {
        Users login=usersService.getUserByEmail(user.getEmail(),user.getPassword());
        if(login == null){
            return "redirect:/login"; // Redirect to login page after
        }else{
            session.setAttribute("login",login);
            return "redirect:/studentDashboard"; // Redirect to dashboard after successful login
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session
        session.invalidate();
        // Redirect to the login page after logout
        return "redirect:/login";
    }

}
