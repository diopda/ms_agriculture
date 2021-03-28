package delta.agriculture.reposy;

import org.springframework.data.jpa.repository.JpaRepository;


import delta.agriculture.domain.partenaire;

public interface PartenaireRepository extends JpaRepository<partenaire, Long> {
	 Iterable <partenaire> findByNom(String nom);

}
