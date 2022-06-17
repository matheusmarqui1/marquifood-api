package marqui.matheus.marquifood.domain.repository;

import marqui.matheus.marquifood.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.List;

public interface CustomizedRestauranteRepositoryQueries {
    List<Restaurante> findPersonalizado(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

    List<Restaurante> findComFreteGratis(String nome);
}
