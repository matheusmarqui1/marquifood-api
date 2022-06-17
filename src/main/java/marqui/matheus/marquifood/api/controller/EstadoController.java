package marqui.matheus.marquifood.api.controller;

import lombok.RequiredArgsConstructor;
import marqui.matheus.marquifood.domain.exception.EntidadeEmUsoException;
import marqui.matheus.marquifood.domain.exception.EntidadeNaoEncontradaException;
import marqui.matheus.marquifood.domain.model.Estado;
import marqui.matheus.marquifood.domain.repository.EstadoRepository;
import marqui.matheus.marquifood.domain.service.CadastroEstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
@RequiredArgsConstructor
public class EstadoController {

    private final EstadoRepository estados;
    private final CadastroEstadoService cadastroEstado;

    @GetMapping
    public List<Estado> listar() {
        return estados.findAll();
    }

    @GetMapping("/{estadoId}")
    public Estado buscar(@PathVariable Long estadoId) {
        return estados.buscaSeguraPorId(estadoId);
    }

    @PostMapping
    public Estado salvar(@RequestBody Estado estado) {
        return cadastroEstado.salvar(estado);
    }

    @PutMapping("/{estadoId}")
    public Estado atualizar(@PathVariable Long estadoId, @RequestBody Estado estado) {
        Estado estadoSalvo = estados.buscaSeguraPorId(estadoId);

        estado.setId(estadoSalvo.getId());

        return cadastroEstado.salvar(estado);
    }

    @DeleteMapping("/{estadoId}")
    public void remover(@PathVariable Long estadoId) {
        cadastroEstado.remover(estadoId);
    }
}
