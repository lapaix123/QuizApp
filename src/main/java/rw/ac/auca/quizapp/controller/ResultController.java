package rw.ac.auca.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rw.ac.auca.quizapp.model.Result;
import rw.ac.auca.quizapp.service.ResultService;

@Controller
public class ResultController {
    @Autowired
    private ResultService resultService;
    // Show form to add a new result
    @GetMapping("/newResult")
    public String showAddResultForm(Model model) {
        model.addAttribute("result", new Result());
        return "ResultForm";
    }


    @PostMapping("/saveResult")
    public String saveResult(@ModelAttribute("result") Result result) {
        resultService.newResult(result);
        return "redirect:/results";
    }


    @GetMapping("/results")
    public String showAllResults(Model model) {
        model.addAttribute("results", resultService.getAllResults());
        return "Results";
    }
}
