package delta.agriculture.reposy;

import delta.agriculture.domain.Ouvrage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OuvrageRepository extends JpaRepository<Ouvrage, Long> {
}
