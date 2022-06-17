package marqui.matheus.marquifood.domain.service;

import lombok.RequiredArgsConstructor;
import marqui.matheus.marquifood.domain.exception.CidadeNaoEncontradaException;
import marqui.matheus.marquifood.domain.exception.EntidadeEmUsoException;
import marqui.matheus.marquifood.domain.exception.EntidadeNaoEncontradaException;
import marqui.matheus.marquifood.domain.exception.EstadoNaoEncontradoException;
import marqui.matheus.marquifood.domain.model.Cidade;
import marqui.matheus.marquifood.domain.model.Estado;
import marqui.matheus.marquifood.domain.repository.CidadeRepository;
import marqui.matheus.marquifood.domain.repository.EstadoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroCidadeService {

    private static final String MSG_CIDADE_EM_USO = "Cidade de código %d está em uso";

    private final CidadeRepository cidades;
    private final EstadoRepository estados;

    public Cidade salvar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();

        try {
            Estado estado = estados.buscaSeguraPorId(estadoId);
            cidade.setEstado(estado);
        } catch (EntidadeNaoEncontradaException e) {
            throw new EstadoNaoEncontradoException(e.getMessage());
        }

        return cidades.save(cidade);
    }

    public void deletar(Long cidadeId) {
        try {
            cidades.deleteById(cidadeId);
        } catch (EmptyResultDataAccessException e) {
            throw new CidadeNaoEncontradaException(cidadeId);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(MSG_CIDADE_EM_USO.formatted(cidadeId));
        }
    }

}
