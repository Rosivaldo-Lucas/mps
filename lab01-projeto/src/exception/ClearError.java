package exception;

public class ClearError extends Exception {

    private final String mensagem;

    public ClearError() {
        this.mensagem = "ClearErrorException";
    }

    public ClearError(final String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMessage() {
        return this.mensagem;
    }

}
