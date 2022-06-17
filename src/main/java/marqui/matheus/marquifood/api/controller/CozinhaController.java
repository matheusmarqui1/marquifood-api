package marqui.matheus.marquifood.api.controller;

import lombok.RequiredArgsConstructor;
import marqui.matheus.marquifood.domain.exception.EntidadeEmUsoException;
import marqui.matheus.marquifood.domain.exception.EntidadeNaoEncontradaException;
import marqui.matheus.marquifood.domain.model.Cozinha;
import marqui.matheus.marquifood.domain.repository.CozinhaRepository;
import marqui.matheus.marquifood.domain.service.CadastroCozinhaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cozinhas")
public class CozinhaController {

    private final CozinhaRepository cozinhas;

    private final CadastroCozinhaService cadastroCozinha;

    @GetMapping
    public List<Cozinha> listar()  {
        return cozinhas.findAll();
    }

    @GetMapping("/{cozinhaId}")
    public Cozinha buscar(@PathVariable Long cozinhaId) {
        return cozinhas.buscaSeguraPorId(cozinhaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
        return cadastroCozinha.salvar(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public Cozinha atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {
        Cozinha cozinhaSalva = cozinhas.buscaSeguraPorId(cozinhaId);

        cozinha.setId(cozinhaSalva.getId());

        return cadastroCozinha.salvar(cozinha);
    }

    @DeleteMapping("/{cozinhaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long cozinhaId) {
        cadastroCozinha.deletar(cozinhaId);
    }

}
