package delta.agriculture.service;

import delta.agriculture.domain.Ouvrage;
import delta.agriculture.domain.Production;
import delta.agriculture.reposy.ProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductionService {

    @Autowired
    private ProductionRepository productionRepository;

    public Optional<Production> getProduction(final Long id) {

        return productionRepository.findById(id);
    }

    public Iterable<Production> getProduction() {

        return productionRepository.findAll();
    }

    public void deleteProduction(final Long id) {
        productionRepository.deleteById(id);
    }

    public Production saveProduction(Production production) {
        Production savedProduction = productionRepository.save(production);
        return savedProduction;
    }
}
