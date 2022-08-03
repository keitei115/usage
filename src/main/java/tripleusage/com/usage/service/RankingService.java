package tripleusage.com.usage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripleusage.com.usage.repository.PokeRepository;
import tripleusage.com.usage.domain.ItemTotal;
import tripleusage.com.usage.domain.MoveTotal;
import tripleusage.com.usage.domain.PokemonTotal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RankingService {

    //private static final Logger logger = LoggerFactory.getLogger(RankingService.class);

    @Autowired
    private PokeRepository repository;

    public List<PokemonTotal> PokemonRanking() {
        return repository.getPokemonTotal();
        }

    public List<ItemTotal> ItemRanking(String pokemom) {
        return repository.getItemTotal(pokemom);
        }

    public List<MoveTotal> MoveRanking(String pokemom) {
        return repository.getMoveTotal(pokemom);
        }
}

