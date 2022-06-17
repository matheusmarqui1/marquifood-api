package marqui.matheus.marquifood.domain.service;

import lombok.RequiredArgsConstructor;
import marqui.matheus.marquifood.domain.exception.CozinhaNaoEncontradaException;
import marqui.matheus.marquifood.domain.exception.EntidadeEmUsoException;
import marqui.matheus.marquifood.domain.exception.EntidadeNaoEncontradaException;
import marqui.matheus.marquifood.domain.model.Cozinha;
import marqui.matheus.marquifood.domain.repository.CozinhaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroCozinhaService {

    private static final String MSG_COZINHA_NAO_ENCONTRADA = "Não existe um cadastro de cozinha com o código %d.";
    private static final String MSG_COZINHA_EM_USO = "Cozinha de código %d não pode ser excluída pois está em uso.";

    final CozinhaRepository cozinhas;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhas.save(cozinha);
    }

    public void deletar(Long cozinhaId) {
        try {
            cozinhas.deleteById(cozinhaId);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(MSG_COZINHA_EM_USO.formatted(cozinhaId));
        }catch (EmptyResultDataAccessException e) {
            throw new CozinhaNaoEncontradaException(MSG_COZINHA_NAO_ENCONTRADA.formatted(cozinhaId));
        }
    }
}
