package tripleusage.com.usage.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripleusage.com.usage.domain.Pokemon;
import tripleusage.com.usage.repository.PokeRepository;


@Service
public class SearchService {
    @Autowired
    private PokeRepository repository;

    public Pokemon getPokemon(String id) {
        Optional<Pokemon> pokeMap = repository.findById(id);
        Pokemon pokemon = new Pokemon();
        pokemon.setPokemonid(pokeMap.orElse(pokemon).getPokemonid());
        pokemon.setName(pokeMap.orElse(pokemon).getName());
        return pokemon;
    }
}