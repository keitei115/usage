package tripleusage.com.usage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;

import tripleusage.com.usage.domain.PokeForm;
import tripleusage.com.usage.domain.Pokemon;
import tripleusage.com.usage.service.NameList;
import tripleusage.com.usage.service.SubmissionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    private static final NameList nameList = new NameList();
    //private static final Logger logger = LoggerFactory.getLogger(SubmissionController.class);

    @ModelAttribute
    PokeForm pokeForm() {
        return new PokeForm();
    }

    @GetMapping("/form")
    public String getSearch(Model model) {
        model.addAttribute("pokemonlist", nameList.getPokemonList());
        model.addAttribute("itemlist", nameList.getItemList());
        model.addAttribute("abilitylist", nameList.getAbilityList());
        model.addAttribute("moveslist", nameList.getMoveList());
        model.addAttribute("naturelist", nameList.getPersonalList());
        model.addAttribute("date", LocalDate.now().toString()); //日付フォームの初期値を今日の日付に
        return "form";
    }

    @GetMapping("/confirm")
    public String getConfirm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<Pokemon> pokemons = (List<Pokemon>) session.getAttribute("pokesubmission");
        if (pokemons == null) {
            return "redirect:https://triplefreedatabase.net/form";
        }
        model.addAttribute("pokemons", pokemons);
        return "confirm";
    }

    @PostMapping(params = "ok", value = "/confirm")
    public String postConfirm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<Pokemon> pokemons = (List<Pokemon>) session.getAttribute("pokesubmission");
        submissionService.submitPokemon(pokemons);
        session.removeAttribute("pokesubmission");
        return "redirect:https://triplefreedatabase.net/form";
    }

    @PostMapping(params = "cancel", value = "/confirm")
    public String postCancel(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("pokesubmission");
        return "redirect:https://triplefreedatabase.net/form";
    }

    @PostMapping("/form")
    public String addPokemon(@Validated @ModelAttribute("pokeForm") PokeForm pokeform, BindingResult result, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (result.hasErrors()) {
            model.addAttribute("pokemonlist", nameList.getPokemonList());
            model.addAttribute("itemlist", nameList.getItemList());
            model.addAttribute("abilitylist", nameList.getAbilityList());
            model.addAttribute("moveslist", nameList.getMoveList());
            model.addAttribute("naturelist", nameList.getPersonalList());
            model.addAttribute("date", LocalDate.now().toString());
            return "form";
        }
        List<Pokemon> pokemons = submissionService.getPokemonList(pokeform);
        session.setAttribute("pokesubmission", pokemons);
        return "redirect:https://triplefreedatabase.net/confirm";
    }
}