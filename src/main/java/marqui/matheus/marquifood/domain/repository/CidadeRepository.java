package marqui.matheus.marquifood.domain.repository;

import marqui.matheus.marquifood.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends CustomJpaRepository<Cidade, Long> {

}
