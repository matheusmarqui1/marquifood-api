package marqui.matheus.marquifood.domain.service;

import lombok.RequiredArgsConstructor;
import marqui.matheus.marquifood.domain.exception.EntidadeEmUsoException;
import marqui.matheus.marquifood.domain.exception.EntidadeNaoEncontradaException;
import marqui.matheus.marquifood.domain.exception.EstadoNaoEncontradoException;
import marqui.matheus.marquifood.domain.model.Estado;
import marqui.matheus.marquifood.domain.repository.EstadoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroEstadoService {

    private static final String MSG_ESTADO_EM_USO = "Estado de código %d está em uso.";

    private final EstadoRepository estados;

    public Estado salvar(Estado estado) {
        return estados.save(estado);
    }

    public void remover(Long estadoId) {
        try{
            estados.deleteById(estadoId);
        }catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(MSG_ESTADO_EM_USO.formatted(estadoId));
        }catch (EmptyResultDataAccessException e) {
            throw new EstadoNaoEncontradoException(estadoId);
        }
    }

}
