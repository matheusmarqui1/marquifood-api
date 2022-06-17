package marqui.matheus.marquifood.api.controller;

import lombok.RequiredArgsConstructor;
import marqui.matheus.marquifood.domain.exception.EstadoNaoEncontradoException;
import marqui.matheus.marquifood.domain.exception.NegocioException;
import marqui.matheus.marquifood.domain.model.Cidade;
import marqui.matheus.marquifood.domain.repository.CidadeRepository;
import marqui.matheus.marquifood.domain.service.CadastroCidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cidades")
public class CidadeController {
    private final CidadeRepository cidades;
    private final CadastroCidadeService cadastroCidade;

    @GetMapping
    private List<Cidade> listar() {
        return cidades.findAll();
    }

    @GetMapping("/{cidadeId}")
    private Cidade buscar(@PathVariable Long cidadeId) {
        return cidades.buscaSeguraPorId(cidadeId);
    }

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Cidade salvar(@RequestBody Cidade cidade) {
        try {
            return cadastroCidade.salvar(cidade);
        } catch (EstadoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Transactional
    @PutMapping("/{cidadeId}")
    private Cidade atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
        try {
            Cidade cidadeSalva = cidades.buscaSeguraPorId(cidadeId);
            cidade.setId(cidadeSalva.getId());

            return cadastroCidade.salvar(cidade);
        } catch (EstadoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Transactional
    @DeleteMapping("/{cidadeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deletar(@PathVariable Long cidadeId) {
        cadastroCidade.deletar(cidadeId);
    }
}
