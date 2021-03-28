package delta.agriculture.service;

import delta.agriculture.domain.Exigible;

import delta.agriculture.reposy.ExibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExigibleService {

    @Autowired
    private ExibleRepository exigibleRepository;

    public Optional<Exigible> getExigible(final Long id) {
        return exigibleRepository.findById(id);
    }

    public Iterable<Exigible> getExigible() {
        return exigibleRepository.findAll();
    }

    public void deleteExigible(final Long id) {
        exigibleRepository.deleteById(id);
    }

    public Exigible saveExigible(Exigible exigible) {
        Exigible savedExigible = exigibleRepository.save(exigible);
        return savedExigible;
    }
}
