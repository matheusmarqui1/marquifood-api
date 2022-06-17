package marqui.matheus.marquifood.domain.exception;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {
    public CidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CidadeNaoEncontradaException(Long cidadeId) {
        this("Cidade de código %d não existe.".formatted(cidadeId));
    }
}
