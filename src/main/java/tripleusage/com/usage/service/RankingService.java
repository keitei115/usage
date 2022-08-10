package tripleusage.com.usage.service;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripleusage.com.usage.repository.PokeRepository;
import tripleusage.com.usage.domain.AbilityTotal;
import tripleusage.com.usage.domain.ItemTotal;
import tripleusage.com.usage.domain.MoveTotal;
import tripleusage.com.usage.domain.NatureTotal;
import tripleusage.com.usage.domain.PokemonTotal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RankingService {

    //private static final Logger logger = LoggerFactory.getLogger(RankingService.class);

    @Autowired
    private PokeRepository repository;

    public List<PokemonTotal> PokemonRanking(String before, String after) {
        return repository.getPokemonTotal(before, after);
        }

    public List<ItemTotal> ItemRanking(String pokemom, String before, String after) {
        return repository.getItemTotal(pokemom, before, after);
        }

    public List<MoveTotal> MoveRanking(String pokemom, String before, String after) {
        return repository.getMoveTotal(pokemom, before, after);
        }

    public List<NatureTotal> NatureRanking(String pokemom, String before, String after) {
        return repository.getNatureTotal(pokemom, before, after);
        }

    public List<AbilityTotal> AbilityRanking(String pokemom, String before, String after) {
        return repository.getAbilityTotal(pokemom, before, after);
    }

    public List<PokemonTotal> SamePartyRanking(String pokemom, String before, String after) {
        return repository.getPokemonTotalBySameParty(pokemom, before, after);
        }

    public float PokemonUsage(String pokemom, String before, String after) {
        return repository.getPokemonUsage(pokemom, before, after);
        }

    public Boolean checkDate(String before, String after) {
        try {
            LocalDate beforeDate = LocalDate.parse(before);
            LocalDate afterDate = LocalDate.parse(after);
            if (beforeDate.compareTo(afterDate) > 0) {
                return false;
            } else {
                if (beforeDate.compareTo(LocalDate.parse("2000-01-01")) < 0 || afterDate.compareTo(LocalDate.parse("2999-12-31")) > 0) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }
}

