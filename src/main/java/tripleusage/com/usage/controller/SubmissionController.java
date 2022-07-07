package tripleusage.com.usage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tripleusage.com.usage.service.SubmissionService;

@Controller
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @GetMapping("/form")
    public String getSearch(Model model) {
        return "form";
    }

    @PostMapping("/form")
    public String addPokemon(@RequestParam("form") String name, Model model) {
        submissionService.submitPokemon(name);
        return "form";
    }
}