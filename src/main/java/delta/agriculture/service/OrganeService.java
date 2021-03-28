package delta.agriculture.service;

import delta.agriculture.domain.Maintenance;
import delta.agriculture.domain.Organe;
import delta.agriculture.reposy.OrganeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganeService {

    @Autowired
    private OrganeRepository organeRepository;

    public Optional<Organe> getOrgane(final Long id) {
        return organeRepository.findById(id);
    }

    public Iterable<Organe> getOrgane() {
        return organeRepository.findAll();
    }

    public void deleteOrgane(final Long id) {
        organeRepository.deleteById(id);
    }

    public Organe saveOrgane(Organe organe) {
        Organe savedOrgane = organeRepository.save(organe);
        return savedOrgane;
    }
}
