package tripleusage.com.usage.service;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NameList {
    private List<String> pokemonlist;
    private List<String> itemlist;
    private List<String> movelist;
    private List<String> abilitylist;
    private List<String> personaist;
    public NameList() {
        try {pokemonlist = Files.readAllLines(Paths.get("src/main/resources/PokemonList.txt"));}
        catch (IOException e1) {e1.printStackTrace();}
        try {itemlist = Files.readAllLines(Paths.get("src/main/resources/ItemList.txt"));}
        catch (IOException e2) {e2.printStackTrace();}
        try {movelist = Files.readAllLines(Paths.get("src/main/resources/MoveList.txt"));}
        catch (IOException e3) {e3.printStackTrace();}
        try {personaist = Files.readAllLines(Paths.get("src/main/resources/PersonalList.txt"));}
        catch (IOException e4) {e4.printStackTrace();}
        try {abilitylist = Files.readAllLines(Paths.get("src/main/resources/AbilityList.txt"));}
        catch (IOException e5) {e5.printStackTrace();}
    }
    public List<String> getPokemonList() {
        return pokemonlist;
    }
    public List<String> getItemList() {
        return itemlist;
    }
    public List<String> getMoveList() {
        return movelist;
    }
    public List<String> getAbilityList() {
        return abilitylist;
    }
    public List<String> getPersonalList() {
        return personaist;
    }
}