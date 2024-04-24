package rw.ac.auca.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rw.ac.auca.quizapp.model.Question;
import rw.ac.auca.quizapp.model.Quiz;
import rw.ac.auca.quizapp.service.QuestionService;
import rw.ac.auca.quizapp.service.QuizService;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;

    // Show form to add a new question
    @GetMapping("/newQuestion")
    public String showAddQuestionForm(@RequestParam("quizId") Integer quizId, Model model) {
        // Pass the quiz ID to the model so it can be used in the form
        model.addAttribute("quizId", quizId);
        // Create a new Question object to bind to the form
        model.addAttribute("question", new Question());
        return "Question"; // Thymeleaf template name for the form
    }


    // Save a new question
    @PostMapping("/newQuestion")
    public String addQuestion(@RequestParam("quizId") Integer quizId, @ModelAttribute("question") Question question) {
        // Retrieve the Quiz object based on the quizId
        Quiz quiz = quizService.getQuizById(quizId);
        // Set the Quiz object to the question
        question.setQuiz(quiz);
        // Save the question
        questionService.newQuestion(question);
        return "redirect:/newQuestion"; // Redirect to the list of questions
    }

    // Show form to update an existing question
    @GetMapping("/edit/{id}")
    public String showEditQuestionForm(@PathVariable("id") int questionId, Model model) {
        Question question = questionService.getQuestionById(questionId);
        if (question == null) {
            // Handle if question not found
            return "redirect:/questions";
        }
        model.addAttribute("question", question);
        return "edit-question-form"; // Thymeleaf template name for the form
    }

    // Update an existing question
    @PostMapping("/edit/{id}")
    public String updateQuestion(@PathVariable("id") int questionId, @ModelAttribute("question") Question question) {
        question.setId(questionId); // Ensure the correct question ID is set
        questionService.updateQuestion(question);
        return "redirect:/questions"; // Redirect to the list of questions
    }

    // Delete an existing question
    @GetMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable("id") int questionId) {
        questionService.deleteQuestion(questionId);
        return "redirect:/questions"; // Redirect to the list of questions
    }

    // Show details of a specific question
    @GetMapping("/{id}")
    public String showQuestionDetails(@PathVariable("id") int questionId, Model model) {
        Question question = questionService.getQuestionById(questionId);
        if (question == null) {
            // Handle if question not found
            return "redirect:/questions";
        }
        model.addAttribute("question", question);
        return "question-details"; // Thymeleaf template name for question details
    }

    // Show all questions
    @GetMapping("/dd")
    public String showAllQuestions(Model model) {
        model.addAttribute("questions", questionService.getAllQuestions());
        return "question-list"; // Thymeleaf template name for question list
    }


}
