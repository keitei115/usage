package tripleusage.com.usage.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokeForm {
    private String p1;
    private String i1;
    private String a1;
    private String m1_1;
    private String m1_2;
    private String m1_3;
    private String m1_4;
    private String p2;
    private String i2;
    private String a2;
    private String m2_1;
    private String m2_2;
    private String m2_3;
    private String m2_4;
    private String p3;
    private String i3;
    private String a3;
    private String m3_1;
    private String m3_2;
    private String m3_3;
    private String m3_4;

    private Pokemon returnPokemon(String poid, long paid, String n, String i,String a,String m1,String m2,String m3,String m4){
        return new Pokemon(poid, paid, n, i, a, m1, m2, m3, m4);
    }

    public List<Pokemon> getPokemonList(String id1, String id2, String id3, long paid){
        List<Pokemon> pokemons = new java.util.ArrayList<Pokemon>();
        pokemons.add(returnPokemon(id1, paid, p1, i1, a1, m1_1, m1_2, m1_3, m1_4));
        pokemons.add(returnPokemon(id2, paid, p2, i2, a2, m2_1, m2_2, m2_3, m2_4));
        pokemons.add(returnPokemon(id3, paid, p3, i3, a3, m3_1, m3_2, m3_3, m3_4));
        return pokemons;
    }
}