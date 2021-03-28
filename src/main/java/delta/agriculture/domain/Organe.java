package delta.agriculture.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Long nbrePersonne;
    private String role;
    private Long cuvette;

    @ManyToMany
    @JoinTable( name = "T_Organe_Maintenance_Associations",
            joinColumns = @JoinColumn( name = "idOrgane" ),
            inverseJoinColumns = @JoinColumn( name = "idMaintenance" ) )
    private List<Maintenance> Maintenances = new ArrayList<>();

    
}
