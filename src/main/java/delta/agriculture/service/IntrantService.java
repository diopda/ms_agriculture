package delta.agriculture.service;

import delta.agriculture.domain.Intrant;
import delta.agriculture.reposy.IntrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IntrantService {

    @Autowired
    private IntrantRepository intantRepository;

    public Optional<Intrant> getIntrant(final Long id) {
        return intantRepository.findById(id);
    }

    public Iterable<Intrant> getIntrant() {
        return intantRepository.findAll();
    }

    public void deleteIntrant(final Long id) {
        intantRepository.deleteById(id);
    }

    public Intrant saveIntrant(Intrant intrant) {
        Intrant savedIntrant = intantRepository.save(intrant);
        return savedIntrant;
    }
}
