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

    //private static final Logger logger = LoggerFactory.getLogger(RankingController.class);

    @Autowired
    private RankingService rankingService;

    private static final String RELEASEDATE = "2014-11-21"; // ORAS発売日

    @GetMapping("/ranking")
    public String getPokemonRanking(Model model, HttpServletRequest request) {
        String before = RELEASEDATE;
        String after = LocalDate.now().toString();
        String firstpokemom = rankingService.PokemonRanking(before, after).get(0).getName();
        HttpSession session = request.getSession();
        session.setAttribute("before", before);
        session.setAttribute("after", after);
        model.addAttribute("before", before.replace("-", "/"));
        model.addAttribute("after", after.replace("-", "/"));
        model.addAttribute("afterval", after); // 日付フォームの初期値を今日の日付に
        model.addAttribute("pokemonname", firstpokemom);
        model.addAttribute("pokeranking", rankingService.PokemonRanking(before, after));
        model.addAttribute("itemranking", rankingService.ItemRanking(firstpokemom, before, after));
        model.addAttribute("moveranking", rankingService.MoveRanking(firstpokemom, before, after));
        model.addAttribute("natureranking", rankingService.NatureRanking(firstpokemom, before, after));
        model.addAttribute("abilityranking", rankingService.AbilityRanking(firstpokemom, before, after));
        model.addAttribute("samepartyranking", rankingService.SamePartyRanking(firstpokemom, before, after));
        model.addAttribute("pokemonusage", rankingService.PokemonUsage(firstpokemom, before, after));
        return "ranking";
    }

    @PostMapping(params = "date", value = "/ranking")
    public String postDatePokemonRanking(@RequestParam String before, @RequestParam String after, Model model, HttpServletRequest request) {
        if (rankingService.checkDate(before, after) == false) {
            before = RELEASEDATE;
            after = LocalDate.now().toString();
            model.addAttribute("error", "検索日付が不正です。");
        }
        try {
            rankingService.PokemonRanking(before, after).get(0).getName();
        } catch (Exception e) {
            model.addAttribute("error", "検索範囲にポケモンがいませんでした。");
            HttpSession session = request.getSession();
            before = RELEASEDATE;
            after = LocalDate.now().toString();
            String firstpokemom = rankingService.PokemonRanking(before, after).get(0).getName();
            session.setAttribute("before", before);
            session.setAttribute("after", after);
            model.addAttribute("before", before.replace("-", "/"));
            model.addAttribute("after", after.replace("-", "/"));
            model.addAttribute("afterval", after);
            model.addAttribute("pokemonname", firstpokemom);
            model.addAttribute("pokeranking", rankingService.PokemonRanking(before, after));
            model.addAttribute("itemranking", rankingService.ItemRanking(firstpokemom, before, after));
            model.addAttribute("moveranking", rankingService.MoveRanking(firstpokemom, before, after));
            model.addAttribute("natureranking", rankingService.NatureRanking(firstpokemom, before, after));
            model.addAttribute("abilityranking", rankingService.AbilityRanking(firstpokemom, before, after));
            model.addAttribute("samepartyranking", rankingService.SamePartyRanking(firstpokemom, before, after));
            model.addAttribute("pokemonusage", rankingService.PokemonUsage(firstpokemom, before, after));
            return "ranking";
        }
        String firstpokemom = rankingService.PokemonRanking(before, after).get(0).getName();
        HttpSession session = request.getSession();
        session.setAttribute("before", before);
        session.setAttribute("after", after);
        model.addAttribute("before", before.replace("-", "/"));
        model.addAttribute("after", after.replace("-", "/"));
        model.addAttribute("afterval", after);
        model.addAttribute("pokemonname", firstpokemom);
        model.addAttribute("pokeranking", rankingService.PokemonRanking(before, after));
        model.addAttribute("itemranking", rankingService.ItemRanking(firstpokemom, before, after));
        model.addAttribute("moveranking", rankingService.MoveRanking(firstpokemom, before, after));
        model.addAttribute("natureranking", rankingService.NatureRanking(firstpokemom, before, after));
        model.addAttribute("abilityranking", rankingService.AbilityRanking(firstpokemom, before, after));
        model.addAttribute("samepartyranking", rankingService.SamePartyRanking(firstpokemom, before, after));
        model.addAttribute("pokemonusage", rankingService.PokemonUsage(firstpokemom, before, after));
        return "ranking";
    }

    @PostMapping(params = "name", value = "/ranking")
    public String postPokemonRanking(@RequestParam String name, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            String before = session.getAttribute("before").toString();
            String after = session.getAttribute("after").toString();
            model.addAttribute("before", before.replace("-", "/"));
            model.addAttribute("after", after.replace("-", "/"));
            model.addAttribute("afterval", after);
            model.addAttribute("pokemonname", name);
            model.addAttribute("pokeranking", rankingService.PokemonRanking(before, after));
            model.addAttribute("itemranking", rankingService.ItemRanking(name, before, after));
            model.addAttribute("moveranking", rankingService.MoveRanking(name, before, after));
            model.addAttribute("natureranking", rankingService.NatureRanking(name, before, after));
            model.addAttribute("abilityranking", rankingService.AbilityRanking(name, before, after));
            model.addAttribute("samepartyranking", rankingService.SamePartyRanking(name, before, after));
            model.addAttribute("pokemonusage", rankingService.PokemonUsage(name, before, after));
        } catch (Exception e) {
            String before = RELEASEDATE;
            String after = LocalDate.now().toString();
            String firstpokemom = rankingService.PokemonRanking(before, after).get(0).getName();
            session.setAttribute("before", before);
            session.setAttribute("after", after);
            model.addAttribute("before", before.replace("-", "/"));
            model.addAttribute("after", after.replace("-", "/"));
            model.addAttribute("afterval", after);
            model.addAttribute("pokemonname", firstpokemom);
            model.addAttribute("pokeranking", rankingService.PokemonRanking(before, after));
            model.addAttribute("itemranking", rankingService.ItemRanking(firstpokemom, before, after));
            model.addAttribute("moveranking", rankingService.MoveRanking(firstpokemom, before, after));
            model.addAttribute("natureranking", rankingService.NatureRanking(firstpokemom, before, after));
            model.addAttribute("abilityranking", rankingService.AbilityRanking(firstpokemom, before, after));
            model.addAttribute("samepartyranking", rankingService.SamePartyRanking(firstpokemom, before, after));
            model.addAttribute("pokemonusage", rankingService.PokemonUsage(firstpokemom, before, after));
        }
        return "ranking";
    }
}
