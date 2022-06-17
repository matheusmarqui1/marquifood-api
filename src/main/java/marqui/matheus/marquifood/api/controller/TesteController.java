package marqui.matheus.marquifood.api.controller;

import lombok.RequiredArgsConstructor;
import marqui.matheus.marquifood.domain.model.Cozinha;
import marqui.matheus.marquifood.domain.model.Restaurante;
import marqui.matheus.marquifood.domain.repository.CozinhaRepository;
import marqui.matheus.marquifood.domain.repository.RestauranteRepository;
import static marqui.matheus.marquifood.infrastructure.repository.spec.RestauranteSpecifications.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
@RequiredArgsConstructor
public class TesteController {

    private final CozinhaRepository cozinhas;
    private final RestauranteRepository restaurantes;

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> cozinhasPorNome(@RequestParam String nome) {
        return cozinhas.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> cozinhasPorNome(@RequestParam BigDecimal taxaInicial, @RequestParam BigDecimal taxaFinal) {
        return restaurantes.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> restaurantesPorNome(@RequestParam String nome, @RequestParam Long cozinhaId) {
        return restaurantes.consultarPorNome(nome, cozinhaId);
    }

    @GetMapping("/restaurantes/por-nome-taxa")
    public List<Restaurante> restaurantesPorNome(@RequestParam(required = false) String nome,
                                                 @RequestParam(required = false) BigDecimal taxaInicial,
                                                 @RequestParam(required = false) BigDecimal taxaFinal) {
        return restaurantes.findPersonalizado(nome, taxaInicial, taxaFinal);
    }

    @GetMapping("/restaurantes/quantidade-por-cozinha")
    public Integer restaurantesPorNome(@RequestParam Long cozinhaId) {
        return restaurantes.countByCozinhaId(cozinhaId);
    }

    @GetMapping("/restaurantes/com-frete-gratis")
    public List<Restaurante> restaurantesComFreteGratis(String nome) {
        return restaurantes.findComFreteGratis(nome);
    }

    @GetMapping("/restaurantes/primeiro")
    public Optional<Restaurante> buscarPrimeiro() {
        return restaurantes.buscarPrimeiro();
    }

}
