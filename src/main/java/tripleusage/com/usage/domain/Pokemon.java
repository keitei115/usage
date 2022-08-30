package tripleusage.com.usage.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pokemon {
    @Id
    private int pokemonid;
    private long partyid;
    private String name;
    private String item;
    private String ability;
    private String nature;
    private String move1;
    private String move2;
    private String move3;
    private String move4;
    private LocalDate date;
}