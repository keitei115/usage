package tripleusage.com.usage.domain;

//import javax.persistence.Column;
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
    private String pokemonid;
    private long partyid;
    private String name;
    private String item;
    private String ability;
    private String move1;
    private String move2;
    private String move3;
    private String move4;
}