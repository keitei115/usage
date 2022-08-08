package tripleusage.com.usage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tripleusage.com.usage.domain.ItemTotal;
import tripleusage.com.usage.domain.MoveTotal;
import tripleusage.com.usage.domain.Pokemon;
import tripleusage.com.usage.domain.PokemonTotal;
import tripleusage.com.usage.domain.NatureTotal;

@Repository
public interface PokeRepository extends JpaRepository<Pokemon, String> {
    @Query(value = "SELECT NAME, COUNT(NAME) AS pokemontotal FROM POKEMON WHERE DATE BETWEEN ?1 AND ?2 GROUP BY NAME ORDER BY pokemontotal DESC", nativeQuery = true)
    List<PokemonTotal> getPokemonTotal(String before, String after);

    @Query(value = "SELECT item, COUNT(item) / (SELECT CAST(COUNT(item) AS REAL) FROM pokemon WHERE name = ?1 AND date BETWEEN ?2 AND ?3) * 100.0 AS itemtotal FROM pokemon WHERE name = ?1 AND date BETWEEN ?2 AND ?3 GROUP BY item ORDER BY itemtotal DESC LIMIT 20", nativeQuery = true)
    List<ItemTotal> getItemTotal(@Param("name") String name, String before, String after);

    @Query(value = "SELECT MOVE1 AS MOVE,COUNT(*) / (SELECT CAST(COUNT(*) AS REAL) FROM POKEMON WHERE NAME = ?1 AND date BETWEEN ?2 AND ?3 ) * 100.0 AS movetotal FROM (SELECT MOVE1 FROM POKEMON WHERE NAME = ?1 AND date BETWEEN ?2 AND ?3 UNION ALL SELECT MOVE2 FROM POKEMON WHERE NAME = ?1 AND date BETWEEN ?2 AND ?3 UNION ALL SELECT MOVE3 FROM POKEMON WHERE NAME = ?1 AND date BETWEEN ?2 AND ?3 UNION ALL SELECT MOVE4 FROM POKEMON WHERE NAME = ?1 AND date BETWEEN ?2 AND ?3)  GROUP BY MOVE1 ORDER BY movetotal DESC LIMIT 30", nativeQuery = true)
    List<MoveTotal> getMoveTotal(@Param("name") String name, String before, String after);

    @Query(value = "SELECT nature, COUNT(nature) / (SELECT CAST(COUNT(nature) AS REAL) FROM pokemon WHERE name = ?1 AND date BETWEEN ?2 AND ?3) * 100.0 AS naturetotal FROM pokemon WHERE name = ?1 AND date BETWEEN ?2 AND ?3 GROUP BY nature ORDER BY naturetotal DESC LIMIT 25", nativeQuery = true)
    List<NatureTotal> getNatureTotal(@Param("name") String name, String before, String after);

    @Query(value = "SELECT MAX(partyid) FROM POKEMON", nativeQuery = true)
    Long maxPartyId();
}