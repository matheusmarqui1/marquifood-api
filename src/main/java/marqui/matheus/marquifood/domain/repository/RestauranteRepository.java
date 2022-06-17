package marqui.matheus.marquifood.domain.repository;

import marqui.matheus.marquifood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>, CustomizedRestauranteRepositoryQueries,
        JpaSpecificationExecutor<Restaurante> {

    @Query("from Restaurante r left join fetch r.cozinha")
    public List<Restaurante> findAll();

    public List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

    public List<Restaurante> findByNomeContainingIgnoreCaseAndCozinhaId(String nome, Long cozinhaId);

    public Optional<Restaurante> findFirstByNomeContaining(String nome);

    public List<Restaurante> findTop2ByNomeContaining(String nome);

    public Boolean existsByNome(String nome);

    public Integer countByCozinhaId(Long cozinhaId);

    public List<Restaurante> consultarPorNome(String nome, Long cozinhaId);

}
