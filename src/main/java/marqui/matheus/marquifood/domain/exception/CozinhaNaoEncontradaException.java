package marqui.matheus.marquifood.domain.exception;

public class CozinhaNaoEncontradaException extends EntidadeNaoEncontradaException {
    public CozinhaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CozinhaNaoEncontradaException(Long cozinhaId) {
        this("Cozinha de código %d não existe.".formatted(cozinhaId));
    }
}
