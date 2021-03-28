package delta.agriculture.reposy;

import delta.agriculture.domain.Saison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaisonRepository extends JpaRepository<Saison, Long> {
}
