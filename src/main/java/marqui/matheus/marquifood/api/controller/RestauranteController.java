package marqui.matheus.marquifood.api.controller;

import lombok.RequiredArgsConstructor;
import marqui.matheus.marquifood.domain.exception.CozinhaNaoEncontradaException;
import marqui.matheus.marquifood.domain.exception.EntidadeNaoEncontradaException;
import marqui.matheus.marquifood.domain.exception.NegocioException;
import marqui.matheus.marquifood.domain.model.Restaurante;
import marqui.matheus.marquifood.domain.repository.RestauranteRepository;
import marqui.matheus.marquifood.domain.service.CadastroRestauranteService;
import marqui.matheus.marquifood.util.ObjectParser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final RestauranteRepository restaurantes;
    private final CadastroRestauranteService cadastroRestaurante;

    @GetMapping
    private List<Restaurante> listar() {
        return restaurantes.findAll();
    }

    @GetMapping("/{restauranteId}")
    private Restaurante buscar(@PathVariable Long restauranteId) {
        return restaurantes.buscaSeguraPorId(restauranteId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Restaurante salvar(@RequestBody Restaurante restaurante) {
        try {
            return cadastroRestaurante.salvar(restaurante);
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }

    }

    @PutMapping("/{restauranteId}")
    private Restaurante atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
        try {
            Restaurante restauranteSalvo = restaurantes.buscaSeguraPorId(restauranteId);

            restaurante.setId(restauranteSalvo.getId());
            restaurante.setFormasPagamento(restauranteSalvo.getFormasPagamento());
            restaurante.setEndereco(restauranteSalvo.getEndereco());
            restaurante.setDataCadastro(restauranteSalvo.getDataCadastro());
            restaurante.setProdutos(restauranteSalvo.getProdutos());

            return cadastroRestaurante.salvar(restaurante);
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }

    }

    @PatchMapping("/{restauranteId}")
    public Restaurante atualizarParcial(@PathVariable Long restauranteId,  @RequestBody Map<String, Object> campos) {
        Restaurante restauranteSalvo = restaurantes.buscaSeguraPorId(restauranteId);

        ObjectParser.to(Restaurante.class).mergeRequestBodyToGenericObject(campos, restauranteSalvo);

        return atualizar(restauranteId, restauranteSalvo);
    }

}
