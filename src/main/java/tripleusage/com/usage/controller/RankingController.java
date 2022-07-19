package tripleusage.com.usage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        model.addAttribute("itemranking", rankingService.ItemRanking("ランドロス霊"));
        model.addAttribute("moveranking", rankingService.MoveRanking("ランドロス霊"));
        return "ranking";
    }
}
