package tripleusage.com.usage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tripleusage.com.usage.controller.Pokemon;
import tripleusage.com.usage.controller.PokemonTotal;
import tripleusage.com.usage.controller.ItemTotal;
import tripleusage.com.usage.controller.MoveTotal;

@Repository
public interface PokeRepository extends JpaRepository<Pokemon, String> {
    @Query(value = "SELECT NAME, COUNT(NAME) AS pokemontotal FROM POKEMON GROUP BY NAME ORDER BY pokemontotal DESC", nativeQuery = true)
    List<PokemonTotal> getPokemonTotal();

    @Query(value = "SELECT item, COUNT(item) / (SELECT CAST(COUNT(item) AS REAL) FROM pokemon WHERE name = ?1) * 100.0 AS itemtotal FROM pokemon WHERE name = ?1 GROUP BY item ORDER BY itemtotal DESC", nativeQuery = true)
    List<ItemTotal> getItemTotal(@Param("name") String name);

    @Query(value = "SELECT MOVE1 AS MOVE,COUNT(*) / (SELECT CAST(COUNT(*) AS REAL) FROM POKEMON WHERE NAME = ?1 ) * 100.0 AS movetotal FROM (SELECT MOVE1 FROM POKEMON WHERE NAME = ?1 UNION ALL SELECT MOVE2 FROM POKEMON WHERE NAME = ?1 UNION ALL SELECT MOVE3 FROM POKEMON WHERE NAME = ?1 UNION ALL SELECT MOVE4 FROM POKEMON WHERE NAME = ?1)  GROUP BY MOVE1 ORDER BY movetotal DESC", nativeQuery = true)
    List<MoveTotal> getMoveTotal(@Param("name") String name);
}