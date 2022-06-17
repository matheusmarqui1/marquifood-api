package marqui.matheus.marquifood.domain.exception;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {
    public RestauranteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public RestauranteNaoEncontradoException(Long cidadeId) {
        this("Cidade de código %d não existe.".formatted(cidadeId));
    }
}
