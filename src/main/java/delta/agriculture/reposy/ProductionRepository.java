package delta.agriculture.reposy;

import delta.agriculture.domain.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepository extends JpaRepository<Production, Long> {
}
