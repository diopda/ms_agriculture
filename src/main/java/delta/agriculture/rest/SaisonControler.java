package delta.agriculture.rest;

import delta.agriculture.domain.Ouvrage;
import delta.agriculture.domain.Production;
import delta.agriculture.domain.Saison;
import delta.agriculture.service.SaisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.Date;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SaisonControler {
    @Autowired

    private SaisonService saisonService;

    @RequestMapping(value = "/saisons", method = RequestMethod.POST)
    public Saison createSaison(@RequestBody Saison saison) {

        return saisonService.saveSaison(saison);
    }


   
    @RequestMapping(value = "/saisons/{id}", method = RequestMethod.GET)
    public Saison getSaison(@PathVariable("id") final Long id) {
        Optional<Saison> saison = saisonService.getSaison(id);
        if(saison.isPresent()) {
            return saison.get();
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/saisons", method = RequestMethod.GET)
    public Iterable<Saison> getSaison() {

        return saisonService.getSaison();
    }

   
    @RequestMapping(value = "/saisons/{id}", method = RequestMethod.PUT)
    public Saison updateSaison(@PathVariable("id") final Long id, @RequestBody Saison saison) {
        Optional<Saison> s = saisonService.getSaison(id);
        if(s.isPresent()) {

            Saison nouveauSaison = s.get();

            String nom =saison.getNom();
            if(nom != null) {
                nouveauSaison.setNom(nom);
            }

           Long annee = saison.getAnnee();
            if(annee != null) {
                nouveauSaison.setAnnee(annee);
            }






            saisonService.saveSaison(nouveauSaison);
            return nouveauSaison;
        } else {
            return null;
        }
    }


    @RequestMapping(value = "/saisons/{id}", method = RequestMethod.DELETE)
    public void deleteSaison(@PathVariable("id") final Long id) {

        saisonService.deleteSaison(id);
    }
}
