package tripleusage.com.usage.service;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripleusage.com.usage.repository.PokeRepository;
import tripleusage.com.usage.controller.PokeForm;
import tripleusage.com.usage.controller.Pokemon;

import java.util.List;

@Service
public class SubmissionService {
    @Autowired
    private PokeRepository repository;

    public List<Pokemon> submitPokemon(PokeForm pokeForm) {
        long id = repository.count();
        List<Pokemon> pokemons = pokeForm.getPokemonList(id+1+"", id+2+"", id+3+"", repository.maxPartyId()+1);
        //for (Pokemon pokemon : pokemons) {
        //    repository.saveAndFlush(pokemon);
        //}
        return pokemons;
    }
}