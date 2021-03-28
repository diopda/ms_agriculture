package delta.agriculture.service;


import delta.agriculture.domain.Ouvrage;
import delta.agriculture.reposy.OuvrageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OuvrageService {
    @Autowired
    private OuvrageRepository ouvrageRepository;

    public Optional<Ouvrage> getOuvrage(final Long id) {
        return ouvrageRepository.findById(id);
    }

    public Iterable<Ouvrage> getOuvrage() {
        return ouvrageRepository.findAll();
    }

    public void deleteOuvrage(final Long id) {
        ouvrageRepository.deleteById(id);
    }

    public Ouvrage saveOuvrage(Ouvrage ouvrage) {
        Ouvrage savedOuvrage = ouvrageRepository.save(ouvrage);
        return savedOuvrage;
    }
}
