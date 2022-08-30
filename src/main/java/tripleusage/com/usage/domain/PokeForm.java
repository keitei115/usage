package tripleusage.com.usage.domain;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import tripleusage.com.usage.annotation.PokeCheck;
import tripleusage.com.usage.annotation.ItemCheck;
import tripleusage.com.usage.annotation.MoveCheck;
import tripleusage.com.usage.annotation.AbilityCheck;
import tripleusage.com.usage.annotation.NatureCheck;
import tripleusage.com.usage.annotation.DateCheck;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokeForm {
    @NotBlank(message = "入力していない欄があります") @PokeCheck(message = "ポケモンの名前が間違っています")
    private String p1;
    @NotBlank(message = "入力していない欄があります") @ItemCheck(message = "アイテムの名前が間違っています")
    private String i1;
    @NotBlank(message = "入力していない欄があります") @AbilityCheck(message = "特性の名前が間違っています")
    private String a1;
    @NotBlank(message = "入力していない欄があります") @NatureCheck(message = "性格の名前が間違っています")
    private String n1;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m1_1;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m1_2;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m1_3;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m1_4;
    @NotBlank(message = "入力していない欄があります") @PokeCheck(message = "ポケモンの名前が間違っています")
    private String p2;
    @NotBlank(message = "入力していない欄があります") @ItemCheck(message = "アイテムの名前が間違っています")
    private String i2;
    @NotBlank(message = "入力していない欄があります") @AbilityCheck(message = "特性の名前が間違っています")
    private String a2;
    @NotBlank(message = "入力していない欄があります") @NatureCheck(message = "性格の名前が間違っています")
    private String n2;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m2_1;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m2_2;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m2_3;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m2_4;
    @NotBlank(message = "入力していない欄があります") @PokeCheck(message = "ポケモンの名前が間違っています")
    private String p3;
    @NotBlank(message = "入力していない欄があります") @ItemCheck(message = "アイテムの名前が間違っています")
    private String i3;
    @NotBlank(message = "入力していない欄があります") @AbilityCheck(message = "特性の名前が間違っています")
    private String a3;
    @NotBlank(message = "入力していない欄があります") @NatureCheck(message = "性格の名前が間違っています")
    private String n3;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m3_1;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m3_2;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m3_3;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m3_4;
    @NotBlank(message = "入力していない欄があります") @PokeCheck(message = "ポケモンの名前が間違っています")
    private String p4;
    @NotBlank(message = "入力していない欄があります") @ItemCheck(message = "アイテムの名前が間違っています")
    private String i4;
    @NotBlank(message = "入力していない欄があります") @AbilityCheck(message = "特性の名前が間違っています")
    private String a4;
    @NotBlank(message = "入力していない欄があります") @NatureCheck(message = "性格の名前が間違っています")
    private String n4;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m4_1;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m4_2;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m4_3;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m4_4;
    @NotBlank(message = "入力していない欄があります") @PokeCheck(message = "ポケモンの名前が間違っています")
    private String p5;
    @NotBlank(message = "入力していない欄があります") @ItemCheck(message = "アイテムの名前が間違っています")
    private String i5;
    @NotBlank(message = "入力していない欄があります") @AbilityCheck(message = "特性の名前が間違っています")
    private String a5;
    @NotBlank(message = "入力していない欄があります") @NatureCheck(message = "性格の名前が間違っています")
    private String n5;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m5_1;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m5_2;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m5_3;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m5_4;
    @NotBlank(message = "入力していない欄があります") @PokeCheck(message = "ポケモンの名前が間違っています")
    private String p6;
    @NotBlank(message = "入力していない欄があります") @ItemCheck(message = "アイテムの名前が間違っています")
    private String i6;
    @NotBlank(message = "入力していない欄があります") @AbilityCheck(message = "特性の名前が間違っています")
    private String a6;
    @NotBlank(message = "入力していない欄があります") @NatureCheck(message = "性格の名前が間違っています")
    private String n6;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m6_1;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m6_2;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m6_3;
    @NotBlank(message = "入力していない欄があります") @MoveCheck(message = "わざ名が間違っています")
    private String m6_4;
    @NotBlank(message = "入力していない欄があります") @DateCheck(message = "日付が間違っています")
    private String d;

    private Pokemon returnPokemon(int poid, long paid, String p, String i, String a, String n, String m1, String m2, String m3, String m4, LocalDate d) {
        return new Pokemon(poid, paid, p, i, a, n, m1, m2, m3, m4, d);
    }
    public List<Pokemon> getPokemonList(int id1, int id2, int id3, int id4, int id5, int id6, long paid){
        List<Pokemon> pokemons = new java.util.ArrayList<Pokemon>();
        pokemons.add(returnPokemon(id1, paid, p1, i1, a1, n1, m1_1, m1_2, m1_3, m1_4, LocalDate.parse(d, DateTimeFormatter.ISO_DATE)));
        pokemons.add(returnPokemon(id2, paid, p2, i2, a2, n2, m2_1, m2_2, m2_3, m2_4, LocalDate.parse(d, DateTimeFormatter.ISO_DATE)));
        pokemons.add(returnPokemon(id3, paid, p3, i3, a3, n3, m3_1, m3_2, m3_3, m3_4, LocalDate.parse(d, DateTimeFormatter.ISO_DATE)));
        pokemons.add(returnPokemon(id4, paid, p4, i4, a4, n4, m4_1, m4_2, m4_3, m4_4, LocalDate.parse(d, DateTimeFormatter.ISO_DATE)));
        pokemons.add(returnPokemon(id5, paid, p5, i5, a5, n5, m5_1, m5_2, m5_3, m5_4, LocalDate.parse(d, DateTimeFormatter.ISO_DATE)));
        pokemons.add(returnPokemon(id6, paid, p6, i6, a6, n6, m6_1, m6_2, m6_3, m6_4, LocalDate.parse(d, DateTimeFormatter.ISO_DATE)));
        return pokemons;
    }

    public List<Boolean> checkPokemon(List<Pokemon> pokemons){
        List<Boolean> check = new java.util.ArrayList<Boolean>();
        return check;
    }
}