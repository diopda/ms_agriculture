package delta.agriculture.rest;

import delta.agriculture.domain.Maintenance;

import delta.agriculture.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MaintenanceControler {


    @Autowired
    private MaintenanceService maintenanceService;

 
    @RequestMapping(value = "/maintenances", method = RequestMethod.POST)
    public Maintenance createCuvette(@RequestBody Maintenance maintenance) {

        return maintenanceService.saveMaintenance(maintenance);
    }


   
    @RequestMapping(value = "/maintenances/{id}", method = RequestMethod.GET)
    public Maintenance getMaintenance(@PathVariable("id") final Long id) {
        Optional<Maintenance> maintenance = maintenanceService.getMaintenance(id);
        if(maintenance.isPresent()) {
            return maintenance.get();
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/maintenances", method = RequestMethod.GET)
    public Iterable<Maintenance> getMaintenance() {

        return maintenanceService.getMaintenance();
    }

 
    @RequestMapping(value = "/maintenances/{id}", method = RequestMethod.PUT)
    public Maintenance updateMaintenance(@PathVariable("id") final Long id, @RequestBody Maintenance maintenance) {
        Optional<Maintenance> m = maintenanceService.getMaintenance(id);
        if(m.isPresent()) {
            Maintenance nouveauMaintenance = m.get();

            String intervention =maintenance.getIntervention();
            if(intervention != null) {
                nouveauMaintenance.setIntervention(intervention);
            }


            String frequence = maintenance.getFrequence();

            if(frequence != null) {
                nouveauMaintenance.setFrequence(frequence);
            }
            String prestataire = maintenance.getPrestataire();
            if(prestataire != null) {
                nouveauMaintenance.setPrestataire(prestataire);
            }
            Long fraisMaintenance = maintenance.getFraisMaintenance();
            if(fraisMaintenance != null) {
                nouveauMaintenance.setFraisMaintenance(fraisMaintenance);
            }
            String type = maintenance.getType();
            if(type != null) {

                nouveauMaintenance.setType(type);
            }
            Date annee = maintenance.getAnnee();

            if(annee != null) {
                nouveauMaintenance.setAnnee(annee);
            }




            maintenanceService.saveMaintenance(nouveauMaintenance);
            return nouveauMaintenance;
        } else {
            return null;
        }
    }


 
    @RequestMapping(value = "/maintenances/{id}", method = RequestMethod.DELETE)
    public void deleteMaintenance(@PathVariable("id") final Long id) {

        maintenanceService.deleteMaintenance(id);
    }
}
