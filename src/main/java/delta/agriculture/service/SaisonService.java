package delta.agriculture.service;

import delta.agriculture.domain.Saison;

import delta.agriculture.reposy.SaisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SaisonService {

    @Autowired
    private SaisonRepository saisonRepository;

    public Optional<Saison> getSaison(final Long id) {
        return saisonRepository.findById(id);
    }

    public Iterable<Saison> getSaison() {
        return saisonRepository.findAll();
    }

    public void deleteSaison(final Long id) {
        saisonRepository.deleteById(id);
    }

    public Saison saveSaison(Saison saison) {
        Saison savedSaison = saisonRepository.save(saison);
        return savedSaison;
    }
}
