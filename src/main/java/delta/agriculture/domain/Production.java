package delta.agriculture.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Production  {

    /**
	 * 
	 */

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String reference;
    private  Long superficie;
    private  Long rendementTpH;
    private  Long productionT;
    private  String paysan ;
    private  Long cuvette;
    private  Long unions;
    private  Long section;
    private  Long groupement;

    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idSaison", nullable=false)
    private Saison saison;

    
}
