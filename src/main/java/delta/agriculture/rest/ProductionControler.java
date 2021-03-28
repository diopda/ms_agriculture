package delta.agriculture.rest;

import delta.agriculture.domain.Production;
import delta.agriculture.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductionControler {

    @Autowired

    private ProductionService productionService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/production", method = RequestMethod.POST)
    public Production createProduction(@RequestBody Production production) {

        return productionService.saveProduction(production);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/production/{id}", method = RequestMethod.GET)
    public Production getProduction(@PathVariable("id") final Long id) {
        Optional<Production> production = productionService.getProduction(id);
        if(production.isPresent()) {
            return production.get();
        } else {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/productions", method = RequestMethod.GET)
    public Iterable<Production> getProduction() {

        return productionService.getProduction();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/production/{id}", method = RequestMethod.PUT)
    public Production updateProduction(@PathVariable("id") final Long id, @RequestBody Production production) {
        Optional<Production> p = productionService.getProduction(id);
        if(p.isPresent()) {

            Production nouveauProduction = p.get();

            String reference =production.getReference();
            if(reference != null) {
                nouveauProduction.setReference(reference);
            }

            Long sup = production.getSuperficie();
            if(sup != null) {
                nouveauProduction.setSuperficie(sup);
            }
            
            Long rendement = production.getRendementTpH();
            
            if(rendement != null) {
            	
                nouveauProduction.setRendementTpH(rendement);
            }
            Long productionT= production.getProductionT();
            if( productionT!= null) {
                nouveauProduction.setProductionT(productionT);
            }
            String paysan= production.getPaysan();
            if( paysan!= null) {
                nouveauProduction.setPaysan(paysan);
            }
            Long cuvette= production.getCuvette();
            if( cuvette!= null) {
                nouveauProduction.setCuvette(cuvette);
            }

            Long  union= production.getUnions();
            if( union!= null) {
                nouveauProduction.setUnions(union);
            }
            Long section= production.getSection();
            if( section!= null) {
                nouveauProduction.setSection(section);
            }
            Long groupement = production.getGroupement();
            if( groupement!= null) {
                nouveauProduction.setGroupement(groupement);
            }

            productionService.saveProduction(nouveauProduction);
            return nouveauProduction;

        } else {
            return null;
        }
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/production/{id}", method = RequestMethod.DELETE)
    public void deleteProduction(@PathVariable("id") final Long id) {

        productionService.deleteProduction(id);
    }
}
