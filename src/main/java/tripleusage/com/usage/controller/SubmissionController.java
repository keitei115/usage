package tripleusage.com.usage.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import tripleusage.com.usage.service.NameList;
import tripleusage.com.usage.service.SubmissionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    private static final Logger logger = LoggerFactory.getLogger(SubmissionController.class);

    @ModelAttribute
    PokeForm pokeForm() {
        return new PokeForm();
    }

    @GetMapping("/form")
    public String getSearch(Model model) {
        return "form";
    }

    @GetMapping("/confirm")
    public String getConfirm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<Pokemon> pokemons = (List<Pokemon>) session.getAttribute("pokesubmission");
        model.addAttribute("pokemons", pokemons);
        return "confirm";
    }

    @PostMapping("/confirm")
    public String postConfirm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<Pokemon> pokemons = (List<Pokemon>) session.getAttribute("pokesubmission");
        submissionService.submitPokemon(pokemons);
        return "redirect:/form";
    }

    @PostMapping("/form")
    public String addPokemon(@Validated @ModelAttribute("pokeForm") PokeForm pokeform, BindingResult result, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream().map(x -> x.getDefaultMessage()).distinct().collect(Collectors.toList());
            List<String> errorfields = result.getFieldErrors().stream().map(x -> x.getField()).distinct().collect(Collectors.toList());
            logger.info("Errors: " + errorfields.toString());
            return "form";
        }
        List<Pokemon> pokemons = submissionService.getPokemonList(pokeform);
        session.setAttribute("pokesubmission", pokemons);
        return "redirect:/confirm";
    }
}