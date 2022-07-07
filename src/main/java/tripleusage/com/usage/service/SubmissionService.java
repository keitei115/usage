package tripleusage.com.usage.service;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripleusage.com.usage.repository.PokeRepository;
import tripleusage.com.usage.controller.Pokemon;


@Service
public class SubmissionService {
    @Autowired
    private PokeRepository repository;

    public Pokemon submitPokemon(String name) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setId(String.valueOf(repository.count()+1));
        repository.saveAndFlush(pokemon);
        return pokemon;
    }
}