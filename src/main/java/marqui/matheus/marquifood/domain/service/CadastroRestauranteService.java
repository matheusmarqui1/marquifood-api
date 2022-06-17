package marqui.matheus.marquifood.domain.service;

import lombok.RequiredArgsConstructor;
import marqui.matheus.marquifood.domain.exception.CozinhaNaoEncontradaException;
import marqui.matheus.marquifood.domain.exception.EntidadeNaoEncontradaException;
import marqui.matheus.marquifood.domain.model.Cozinha;
import marqui.matheus.marquifood.domain.model.Restaurante;
import marqui.matheus.marquifood.domain.repository.CozinhaRepository;
import marqui.matheus.marquifood.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroRestauranteService {

    private final RestauranteRepository restaurantes;
    private final CozinhaRepository cozinhas;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();

        try {
            Cozinha cozinha = cozinhas.buscaSeguraPorId(cozinhaId);
            restaurante.setCozinha(cozinha);
        } catch (EntidadeNaoEncontradaException e) {
            throw new CozinhaNaoEncontradaException(e.getMessage());
        }

        return restaurantes.save(restaurante);
    }
}
