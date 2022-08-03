package tripleusage.com.usage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripleusage.com.usage.repository.PokeRepository;
import tripleusage.com.usage.domain.PokeForm;
import tripleusage.com.usage.domain.Pokemon;

import java.util.List;

@Service
public class SubmissionService {
    @Autowired
    private PokeRepository repository;

    public List<Pokemon> getPokemonList(PokeForm pokeForm) {
        long id = repository.count();
        List<Pokemon> pokemons = pokeForm.getPokemonList(id+1+"", id+2+"", id+3+"", repository.maxPartyId()+1);
        return pokemons;
    }

    public List<Pokemon> submitPokemon(List<Pokemon> pokemons) {
        for (Pokemon pokemon : pokemons) {
            repository.save(pokemon);
        }
        return pokemons;
    }
}