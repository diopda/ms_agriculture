package delta.agriculture.rest;

import delta.agriculture.domain.Organe;
import delta.agriculture.domain.Ouvrage;
import delta.agriculture.service.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OuvrageControler {


    @Autowired
    private OuvrageService ouvrageService;

	
    @RequestMapping(value = "/ouvrages", method = RequestMethod.POST)
    public Ouvrage createOuvrage(@RequestBody Ouvrage ouvrage) {

        return ouvrageService.saveOuvrage(ouvrage);
    }


    @RequestMapping(value = "/ouvrages/{id}", method = RequestMethod.GET)
    public Ouvrage getOuvrage(@PathVariable("id") final Long id) {
        Optional<Ouvrage> ouvrage = ouvrageService.getOuvrage(id);
        if(ouvrage.isPresent()) {
            return ouvrage.get();
        } else {
            return null;
        }
    }


    @RequestMapping(value = "/ouvrages", method = RequestMethod.GET)
    public Iterable<Ouvrage> getOuvrage() {

        return ouvrageService.getOuvrage();
    }

   
    @RequestMapping(value = "/ouvrages/{id}", method = RequestMethod.PUT)
    public Ouvrage updateOuvrage(@PathVariable("id") final Long id, @RequestBody Ouvrage ouvrage) {
        Optional<Ouvrage> o = ouvrageService.getOuvrage(id);
        if(o.isPresent()) {

            Ouvrage nouveauOuvrage = o.get();

            String num =ouvrage.getNumero();
            if(num != null) {
                nouveauOuvrage.setNumero(num);
            }

            String nom = ouvrage.getNom();
            if(nom != null) {
                nouveauOuvrage.setNom(nom);
            }
            String localisation = ouvrage.getLocalisation();
            if(localisation != null) {
                nouveauOuvrage.setLocalisation(localisation);
            }
            String description = ouvrage.getDescription();
            if(description != null) {
                nouveauOuvrage.setDescription(description);
            }
            Long cuvette = ouvrage.getCuvette();
            if(cuvette != null) {
                nouveauOuvrage.setCuvette(cuvette);
            }





            ouvrageService.saveOuvrage(nouveauOuvrage);
            return nouveauOuvrage;
        } else {
            return null;
        }
    }


   
    @RequestMapping(value = "/ouvrages/{id}", method = RequestMethod.DELETE)
    public void deleteOuvrage(@PathVariable("id") final Long id) {

        ouvrageService.deleteOuvrage(id);
    }
}
