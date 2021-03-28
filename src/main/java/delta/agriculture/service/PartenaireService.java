package delta.agriculture.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delta.agriculture.domain.partenaire;
import delta.agriculture.reposy.PartenaireRepository;

@Service
public class PartenaireService {
	  @Autowired
	    private PartenaireRepository partenaireRepository;

	    public Optional<partenaire> getPartenaire(final Long id) {

	        return partenaireRepository.findById(id);
	    }

	    public Iterable<partenaire> getPartenaire() {

	        return partenaireRepository.findAll();
	    }
	    
	    public Iterable <partenaire> getNom(final String nom) {

			return partenaireRepository.findByNom(nom);
		}


	    public void deletePartenaire (final Long id) {
	        partenaireRepository.deleteById(id);
	    }

	    public partenaire savePartenaire(partenaire partenaire) {
	        partenaire savedPartenaire = partenaireRepository.save(partenaire);
	        return savedPartenaire;
	    }

}
