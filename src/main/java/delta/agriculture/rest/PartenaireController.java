package delta.agriculture.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import delta.agriculture.domain.partenaire;
import delta.agriculture.service.PartenaireService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PartenaireController {

	@Autowired
	private PartenaireService partenaireService;

	@PostMapping("/partenaires")
	public partenaire createPartenaire(@RequestBody partenaire partenaire) {

		return partenaireService.savePartenaire(partenaire);
	}



	@GetMapping("/partenaires/{id}")
	public partenaire getPartenaire(@PathVariable("id") final Long id) {
		Optional<partenaire> partenaire = partenaireService.getPartenaire(id);
		if (partenaire.isPresent()) {
			return partenaire.get();
		} else {
			return null;
		}
	}


	

	@GetMapping("/nom/{nom}")
	public Iterable<partenaire> getNom(@PathVariable("nom") final String nom) {
		Iterable<partenaire> partenaire = partenaireService.getNom(nom);
		if (partenaire.iterator().hasNext()){
			return partenaire;
	     }else
			return null;
}

	
	
	 @RequestMapping(value = "/partenaires", method = RequestMethod.GET)
	public Iterable<partenaire> getPartenaires() {
		return partenaireService.getPartenaire();
	}
	


	@PutMapping("/partenaires/{id}")
	public partenaire updatePartenaire(@PathVariable("id") final Long id, @RequestBody partenaire partenaire) {
		Optional<partenaire> p = partenaireService.getPartenaire(id);
		if(p.isPresent()) {
			partenaire nouveauPartenaire = p.get();
			
			String nom = partenaire.getNom();
			if(nom != null) {
				nouveauPartenaire.setNom(nom);
			}
			
			String adresse = partenaire.getAdresse();
			if(adresse != null) {
				nouveauPartenaire.setAdresse(adresse);
			}
			String telephone = partenaire.getTel();
			if(telephone != null) {
				nouveauPartenaire.setTel(telephone);;
			}
			String email = partenaire.getEmail();
			if(email != null) {
				nouveauPartenaire.setEmail(email);
			}
			String type = partenaire.getTypePartenariat();
			if(type != null) {
				nouveauPartenaire.setTypePartenariat(type);;
			}
			
			partenaireService.savePartenaire(nouveauPartenaire);
			return nouveauPartenaire;
		} else {
			return null;
		}
	}
	
	

	
	@DeleteMapping("/paartenaires/{id}")
	public void deletePaysan(@PathVariable("id") final Long id) {
		partenaireService.deletePartenaire(id);
	}
	
}