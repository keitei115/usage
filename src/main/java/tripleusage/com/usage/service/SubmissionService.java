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
        int id = (int) repository.count();
        List<Pokemon> pokemons = pokeForm.getPokemonList(id+1, id+2, id+3, id+4, id+5, id+6, repository.maxPartyId()+1);
        return pokemons;
    }

    public List<Pokemon> submitPokemon(List<Pokemon> pokemons) {
        int id = (int) repository.count();
        for(int i=0;i<6;i++){
            pokemons.get(i).setPokemonid(id+i+1);
            pokemons.get(i).setPartyid(repository.maxPartyId()+1);
        }
        repository.saveAll(pokemons);
        return pokemons;
    }
}