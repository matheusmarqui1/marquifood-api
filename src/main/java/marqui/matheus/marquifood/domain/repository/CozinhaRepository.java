package marqui.matheus.marquifood.domain.repository;

import marqui.matheus.marquifood.domain.model.Cozinha;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

    public List<Cozinha> findByNomeContainingIgnoreCase(String nome);

}
