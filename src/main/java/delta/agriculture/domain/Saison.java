package delta.agriculture.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Saison  {

    /**
	 * 
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom;
    private  Long annee;


    @JsonIgnore
    @OneToMany( targetEntity=Intrant.class, mappedBy="saison" )
    private List<Intrant> intrants = new ArrayList<>();

    @JsonIgnore
    @OneToMany( targetEntity=Exigible.class, mappedBy="saison" )
    private List<Exigible> exigibles = new ArrayList<>();

    @JsonIgnore
    @OneToMany( targetEntity=Production.class, mappedBy="saison" )
    private List<Production> productions = new ArrayList<>();


    


}
