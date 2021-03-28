package delta.agriculture.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String intervention;
    private  String frequence;
    private  String prestataire;
    private  Long  fraisMaintenance;
    private  String type;
    private  Date annee;

    
    @JsonIgnore
    @ManyToMany
    @JoinTable( name = "T_Organe_Maintenance_Associations",
            joinColumns = @JoinColumn( name = "idMaintenance" ),
            inverseJoinColumns = @JoinColumn( name = "idOrgane" ) )
    private List<Organe> organes = new ArrayList<>();
    @JsonIgnore
    @ManyToMany
    @JoinTable( name = "T_Ouvrage_Maintenance_Associations",
            joinColumns = @JoinColumn( name = "idMaintenance" ),
            inverseJoinColumns = @JoinColumn( name = "idOuvrage" ) )
    private List<Ouvrage> ouvrages = new ArrayList<>();

    
}
