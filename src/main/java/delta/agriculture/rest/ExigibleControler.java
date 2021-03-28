package delta.agriculture.rest;

import delta.agriculture.domain.Exigible;
import delta.agriculture.domain.Production;
import delta.agriculture.service.ExigibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ExigibleControler {

    @Autowired

    private ExigibleService ExigibleService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/exigible", method = RequestMethod.POST)
    public Exigible createExigible(@RequestBody Exigible exigible) {

        return ExigibleService.saveExigible(exigible);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/exigible/{id}", method = RequestMethod.GET)
    public Exigible getExigible(@PathVariable("id") final Long id) {
        Optional<Exigible> exigible = ExigibleService.getExigible(id);
        if(exigible.isPresent()) {
            return exigible.get();
        } else {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/exigibles", method = RequestMethod.GET)
    public Iterable<Exigible> getExigible() {

        return ExigibleService.getExigible();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/exigible/{id}", method = RequestMethod.PUT)
    public Exigible updateExigible(@PathVariable("id") final Long id, @RequestBody Exigible exigible) {
        Optional<Exigible> e = ExigibleService.getExigible(id);
        if(e.isPresent()) {

            Exigible nouveauExigible = e.get();

            Long paysan =exigible.getPaysan();
            if(paysan != null) {
                nouveauExigible.setPaysan(paysan);
            }

            Long numero = exigible.getNumero();
            if(numero != null) {
                nouveauExigible.setNumero(numero);
            }

            Long numMembre = exigible.getNumero_membre();

            if(numMembre != null) {

                nouveauExigible.setNumero_membre(numMembre);
            }
            String coutHydolique= exigible.getCout_hydrolique();
            if( coutHydolique!= null) {
                nouveauExigible.setCout_hydrolique(coutHydolique);
            }
            Long  quantiteHudrolique= exigible.getQuantitehydrolique();
            if( quantiteHudrolique!= null) {
                nouveauExigible.setQuantitehydrolique(quantiteHudrolique);
            }
            Long prixUhydrolique= exigible.getPUhydrolique();
            if( prixUhydrolique!= null) {
                nouveauExigible.setPUhydrolique(prixUhydrolique);
            }



            ExigibleService.saveExigible(nouveauExigible);
            return nouveauExigible;

        } else {
            return null;
        }
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/exigible/{id}", method = RequestMethod.DELETE)
    public void deleteExigible(@PathVariable("id") final Long id) {

        ExigibleService.deleteExigible(id);
    }
}
