package marqui.matheus.marquifood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
    ENTIDADE_NAO_ENCONTRADA("entidade-nao-encontrada", "Entidade não encontrada."),
    ENTIDADE_EM_USO("entidade-em-uso", "Entidade em uso.");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://marquifood.com.br/%s".formatted(path);
        this.title = title;
    }
}
