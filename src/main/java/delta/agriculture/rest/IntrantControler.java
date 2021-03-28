package delta.agriculture.rest;

import delta.agriculture.domain.Intrant;
import delta.agriculture.service.IntrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IntrantControler {


    @Autowired
    private IntrantService intrantService;

    
    @RequestMapping(value = "/intrants", method = RequestMethod.POST)
    public Intrant createCuvette(@RequestBody Intrant intrant) {

        return intrantService.saveIntrant(intrant);
    }



    @RequestMapping(value = "/intrants/{id}", method = RequestMethod.GET)
    public Intrant getIntrant(@PathVariable("id") final Long id) {
        Optional<Intrant> intrant = intrantService.getIntrant(id);
        if(intrant.isPresent()) {
            return intrant.get();
        } else {
            return null;
        }
    }

   
    @RequestMapping(value = "/intrants", method = RequestMethod.GET)
    public Iterable<Intrant> getIntrant() {

        return intrantService.getIntrant();
    }

   
    @RequestMapping(value = "/intrants/{id}", method = RequestMethod.PUT)
    public Intrant updateCuvette(@PathVariable("id") final Long id, @RequestBody Intrant intrant) {
        Optional<Intrant> I = intrantService.getIntrant(id);
        if(I.isPresent()) {
            Intrant nouveauIntrant = I.get();

            String reference =intrant.getReference();
            if(reference != null) {
                nouveauIntrant.setReference(reference);
            }


            Long Qsemence = intrant.getQsemence();

            if(Qsemence != null) {
                nouveauIntrant.setQsemence(Qsemence);
            }
            Long QengraisD = intrant.getQengraisDAP();

            if(QengraisD != null) {
                nouveauIntrant.setQengraisDAP(QengraisD);
            }
            Long QengraisU = intrant.getQengraisUREE();

            if(QengraisU != null) {
                nouveauIntrant.setQengraisUREE(QengraisU);
            }
            Long Qlondax = intrant.getQLondax();

            if(Qlondax != null) {
                nouveauIntrant.setQLondax(Qlondax);
            }
            Long Qgranite = intrant.getQgranite();

            if(Qgranite != null) {
                nouveauIntrant.setQgranite(Qgranite);
            }

            Long Qpropanil = intrant.getQpropanil();

            if(Qpropanil != null) {
                nouveauIntrant.setQpropanil(Qpropanil);
            }

            Long Qweedone = intrant.getQweedone();

            if(Qweedone != null) {
                nouveauIntrant.setQweedone(Qweedone);
            }
            Long bayeur = intrant.getBayeur();

            if(bayeur != null) {
                nouveauIntrant.setBayeur(bayeur);
            }
            Long paysan = intrant.getPaysan();

            if(paysan != null) {
                nouveauIntrant.setPaysan(paysan);

            }

            intrantService.saveIntrant(nouveauIntrant);
            return nouveauIntrant;
        } else {
            return null;
        }
    }


    @RequestMapping(value = "/intrants/{id}", method = RequestMethod.DELETE)
    public void deleteIntrant(@PathVariable("id") final Long id) {

        intrantService.deleteIntrant(id);
    }
}
