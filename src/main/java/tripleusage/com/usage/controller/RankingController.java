package tripleusage.com.usage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tripleusage.com.usage.service.RankingService;

@Controller
public class RankingController {

    private static final Logger logger = LoggerFactory.getLogger(RankingController.class);

    @Autowired
    private RankingService rankingService;

    @GetMapping("/ranking")
    public String getPokemonRanking(Model model, HttpServletRequest request) {
        String before = "2014-11-21";
        String after = LocalDate.now().toString();
        logger.info("before: " + before + ", after: " + after);
        String firstpokemom = rankingService.PokemonRanking(before, after).get(0).getName();
        HttpSession session = request.getSession();
        session.setAttribute("before", before);
        session.setAttribute("after", after);
        model.addAttribute("before", before);
        model.addAttribute("after", after);
        model.addAttribute("pokeranking", rankingService.PokemonRanking(before, after));
        model.addAttribute("itemranking", rankingService.ItemRanking(firstpokemom, before, after));
        model.addAttribute("moveranking", rankingService.MoveRanking(firstpokemom, before, after));
        model.addAttribute("natureranking", rankingService.NatureRanking(firstpokemom, before, after));
        return "ranking";
    }

    @PostMapping(params = "date" , value = "/ranking")
    public String postDatePokemonRanking(@RequestParam String before, @RequestParam String after, Model model, HttpServletRequest request) {
        if (rankingService.checkDate(before, after) == false) {
            before = "2014-11-21";
            after = LocalDate.now().toString();
            model.addAttribute("error", "検索日付が不正です。");
        }
        try {
            rankingService.PokemonRanking(before, after).get(0).getName();
        } catch (Exception e) {
            model.addAttribute("error", "検索範囲にポケモンがいませんでした。");
            HttpSession session = request.getSession();
            session.setAttribute("before", before);
            session.setAttribute("after", after);
            model.addAttribute("before", before);
            model.addAttribute("after", after);
            return "ranking";
        }
        String firstpokemom = rankingService.PokemonRanking(before, after).get(0).getName();
        HttpSession session = request.getSession();
        session.setAttribute("before", before);
        session.setAttribute("after", after);
        model.addAttribute("before", before);
        model.addAttribute("after", after);
        model.addAttribute("pokeranking", rankingService.PokemonRanking(before, after));
        model.addAttribute("itemranking", rankingService.ItemRanking(firstpokemom, before, after));
        model.addAttribute("moveranking", rankingService.MoveRanking(firstpokemom, before, after));
        model.addAttribute("natureranking", rankingService.NatureRanking(firstpokemom, before, after));
        return "ranking";
    }

    @PostMapping(params = "name" , value = "/ranking")
    public String postPokemonRanking(@RequestParam String name, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String before = session.getAttribute("before").toString();
        String after = session.getAttribute("after").toString();
        model.addAttribute("before", before);
        model.addAttribute("after", after);
        model.addAttribute("pokeranking", rankingService.PokemonRanking(before, after));
        model.addAttribute("itemranking", rankingService.ItemRanking(name, before, after));
        model.addAttribute("moveranking", rankingService.MoveRanking(name, before, after));
        model.addAttribute("natureranking", rankingService.NatureRanking(name, before, after));
        return "ranking";
    }
}
