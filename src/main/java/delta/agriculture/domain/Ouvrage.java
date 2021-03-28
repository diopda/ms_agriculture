package delta.agriculture.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ouvrage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String numero;
    private  String nom;
    private  String localisation;
    private  String Description;
    private Long cuvette;

    @JsonIgnore
    @ManyToMany
    @JoinTable( name = "T_Ouvrage_Maintenance_Associations",
            joinColumns = @JoinColumn( name = "idOuvrage" ),
            inverseJoinColumns = @JoinColumn( name = "idMaintenance" ) )
    private List<Maintenance> Maintenances = new ArrayList<>();



    
}
