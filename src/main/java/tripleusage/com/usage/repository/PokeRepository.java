package tripleusage.com.usage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tripleusage.com.usage.controller.Pokemon;

@Repository
public interface PokeRepository extends JpaRepository<Pokemon, String> {

}
