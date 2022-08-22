package tripleusage.com.usage.repository;

import java.util.List;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tripleusage.com.usage.domain.AbilityTotal;
import tripleusage.com.usage.domain.ItemTotal;
import tripleusage.com.usage.domain.MoveTotal;
import tripleusage.com.usage.domain.Pokemon;
import tripleusage.com.usage.domain.PokemonTotal;
import tripleusage.com.usage.domain.NatureTotal;

@Repository
public interface PokeRepository extends JpaRepository<Pokemon, String> {
    @Query(value = "SELECT NAME, CAST(COUNT(NAME) AS REAL) / (SELECT MAX(PARTYID) FROM POKEMON WHERE date BETWEEN ?1 AND ?2 ) * 100.0 AS pokemontotal FROM POKEMON WHERE DATE BETWEEN ?1 AND ?2 GROUP BY NAME ORDER BY pokemontotal DESC", nativeQuery = true)
    List<PokemonTotal> getPokemonTotal(LocalDate before, LocalDate after);

    @Query(value = "SELECT item, COUNT(item) / (SELECT CAST(COUNT(item) AS REAL) FROM pokemon WHERE name = ?1 AND date BETWEEN ?2 AND ?3) * 100.0 AS itemtotal FROM pokemon WHERE name = ?1 AND date BETWEEN ?2 AND ?3 GROUP BY item ORDER BY itemtotal DESC LIMIT 20", nativeQuery = true)
    List<ItemTotal> getItemTotal(@Param("name") String name, LocalDate before, LocalDate after);

    @Query(value = "SELECT MOVE1 AS MOVE,COUNT(*) / (SELECT CAST(COUNT(*) AS REAL) FROM POKEMON WHERE NAME = ?1 AND date BETWEEN ?2 AND ?3 ) * 100.0 AS movetotal FROM (SELECT MOVE1 FROM POKEMON WHERE NAME = ?1 AND date BETWEEN ?2 AND ?3 UNION ALL SELECT MOVE2 FROM POKEMON WHERE NAME = ?1 AND date BETWEEN ?2 AND ?3 UNION ALL SELECT MOVE3 FROM POKEMON WHERE NAME = ?1 AND date BETWEEN ?2 AND ?3 UNION ALL SELECT MOVE4 FROM POKEMON WHERE NAME = ?1 AND date BETWEEN ?2 AND ?3) AS MOVES GROUP BY MOVE1 ORDER BY movetotal DESC LIMIT 30", nativeQuery = true)
    List<MoveTotal> getMoveTotal(@Param("name") String name, LocalDate before, LocalDate after);

    @Query(value = "SELECT nature, COUNT(nature) / (SELECT CAST(COUNT(nature) AS REAL) FROM pokemon WHERE name = ?1 AND date BETWEEN ?2 AND ?3) * 100.0 AS naturetotal FROM pokemon WHERE name = ?1 AND date BETWEEN ?2 AND ?3 GROUP BY nature ORDER BY naturetotal DESC LIMIT 25", nativeQuery = true)
    List<NatureTotal> getNatureTotal(@Param("name") String name, LocalDate before, LocalDate after);

    @Query(value = "SELECT ability, COUNT(ability) / (SELECT CAST(COUNT(ability) AS REAL) FROM pokemon WHERE name = ?1 AND date BETWEEN ?2 AND ?3) * 100.0 AS abilitytotal FROM pokemon WHERE name = ?1 AND date BETWEEN ?2 AND ?3 GROUP BY ability ORDER BY abilitytotal DESC LIMIT 5", nativeQuery = true)
    List<AbilityTotal> getAbilityTotal(@Param("name") String name, LocalDate before, LocalDate after);

    @Query(value = "SELECT name,CAST(COUNT(name) AS REAL) / (SELECT COUNT(partyid) FROM POKEMON WHERE name = ?1 AND date BETWEEN ?2 AND ?3) * 100.0 AS pokemontotal FROM POKEMON WHERE date BETWEEN ?2 AND ?3 AND partyid IN (SELECT partyid FROM pokemon WHERE NAME = ?1) AND name != ?1 GROUP BY name ORDER BY pokemontotal DESC LIMIT 20;", nativeQuery = true)
    List<PokemonTotal> getPokemonTotalBySameParty(@Param("name") String name, LocalDate before, LocalDate after);

    @Query(value = "SELECT CAST(COUNT(NAME) AS REAL) / (SELECT COUNT(DISTINCT partyid) FROM POKEMON WHERE date BETWEEN ?2 AND ?3 ) * 100.0 AS pokemontotal FROM POKEMON WHERE DATE BETWEEN ?2 AND ?3  GROUP BY NAME HAVING name = ?1", nativeQuery = true)
    float getPokemonUsage(@Param("name") String name, LocalDate before, LocalDate after);

    @Query(value = "SELECT MAX(partyid) FROM POKEMON", nativeQuery = true)
    Long maxPartyId();
}