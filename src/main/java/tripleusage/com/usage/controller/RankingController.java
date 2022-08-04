package tripleusage.com.usage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tripleusage.com.usage.service.RankingService;

@Controller
public class RankingController {

    //private static final Logger logger = LoggerFactory.getLogger(RankingController.class);

    @Autowired
    private RankingService rankingService;

    @GetMapping("/ranking")
    public String getPokemonRanking(Model model) {
        model.addAttribute("pokeranking", rankingService.PokemonRanking());
        model.addAttribute("itemranking", rankingService.ItemRanking(rankingService.PokemonRanking().get(0).getName()));
        model.addAttribute("moveranking", rankingService.MoveRanking(rankingService.PokemonRanking().get(0).getName()));
        model.addAttribute("natureranking", rankingService.NatureRanking(rankingService.PokemonRanking().get(0).getName()));
        return "ranking";
    }

    @PostMapping("/ranking")
    public String postPokemonRanking(@RequestParam String name, Model model) {
        model.addAttribute("pokeranking", rankingService.PokemonRanking());
        model.addAttribute("itemranking", rankingService.ItemRanking(name));
        model.addAttribute("moveranking", rankingService.MoveRanking(name));
        model.addAttribute("natureranking", rankingService.NatureRanking(name));
        return "ranking";
    }
}
