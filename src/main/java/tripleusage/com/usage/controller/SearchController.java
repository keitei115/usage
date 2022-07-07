package tripleusage.com.usage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tripleusage.com.usage.service.SearchService;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public String getSearch(Model model) {
        return "search";
    }

    @PostMapping("/result")
    public String searchById(@RequestParam("search") String Id, Model model) {
        model.addAttribute("pokemon", searchService.getPokemon(Id));
        return "/result";
    }
}