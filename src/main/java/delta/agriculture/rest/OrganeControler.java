package delta.agriculture.rest;


import delta.agriculture.domain.Organe;
import delta.agriculture.service.OrganeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrganeControler {


    @Autowired
    private OrganeService organeService;


    @RequestMapping(value = "/organes", method = RequestMethod.POST)
    public Organe createOrgane(@RequestBody Organe organe) {

        return organeService.saveOrgane(organe);
    }


    @RequestMapping(value = "/organes/{id}", method = RequestMethod.GET)
    public Organe getOrgane(@PathVariable("id") final Long id) {
        Optional<Organe> organe = organeService.getOrgane(id);
        if(organe.isPresent()) {
            return organe.get();
        } else {
            return null;
        }
    }


    @RequestMapping(value = "/organes", method = RequestMethod.GET)
    public Iterable<Organe> getOrgane() {

        return organeService.getOrgane();
    }

 
    @RequestMapping(value = "/organes/{id}", method = RequestMethod.PUT)
    public Organe updateMaintenance(@PathVariable("id") final Long id, @RequestBody Organe organe) {
        Optional<Organe> o = organeService.getOrgane(id);
        if(o.isPresent()) {

            Organe nouveauOrgane = o.get();

            String nom = organe.getNom();
            if(nom != null) {
                nouveauOrgane.setNom(nom);
            }

          Long nbrePersonne = organe.getNbrePersonne();

            if(nbrePersonne != null) {
                nouveauOrgane.setNbrePersonne(nbrePersonne);
            }
            String role = organe.getRole();
            if(role != null) {
                nouveauOrgane.setRole(role);
            }
            Long cuvette = organe.getCuvette();
            if(cuvette != null) {
                nouveauOrgane.setCuvette(cuvette);
            }




            organeService.saveOrgane(nouveauOrgane);
            return nouveauOrgane;
        } else {
            return null;
        }
    }


 
    @RequestMapping(value = "/organes/{id}", method = RequestMethod.DELETE)
    public void deleteOrgane(@PathVariable("id") final Long id) {

        organeService.deleteOrgane(id);
    }
}
