package tripleusage.com.usage.service;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NameList {
    List<String> pokemonlist;
    List<String> itemlist;
    List<String> movelist;
    public NameList() {
        try {pokemonlist = Files.readAllLines(Paths.get("src/main/java/tripleusage/com/usage/resource/MoveList.txt"));}
        catch (IOException e1) {e1.printStackTrace();}
        try {itemlist = Files.readAllLines(Paths.get("src/main/java/tripleusage/com/usage/resource/ItemList.txt"));}
        catch (IOException e2) {e2.printStackTrace();}
        try {movelist = Files.readAllLines(Paths.get("src/main/java/tripleusage/com/usage/resource/MoveList.txt"));}
        catch (IOException e3) {e3.printStackTrace();}
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
}