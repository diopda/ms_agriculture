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


public class Intrant  {
    /**
	 * 
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String reference;
    private  Long Qsemence;
    private  Long QengraisDAP;
    private  Long QengraisUREE;
    private  Long QLondax;
    private  Long Qgranite;
    private  Long Qpropanil;
    private  Long Qweedone;
    private  Long bayeur;
    private  Long paysan;

    

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idSaison", nullable=false)
    private Saison saison;


    
    
    
    

}
