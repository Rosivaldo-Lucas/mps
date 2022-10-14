package exception;

public class UsuarioLoginException extends Exception {
    
    private final String mensagem;

    public UsuarioLoginException() {
        this.mensagem = "UsuarioLoginException";
    }

    public UsuarioLoginException(final String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMessage() {
        return this.mensagem;
    }

}
