package exception;

public class UsuarioSenhaException extends Exception {
    
    private final String mensagem;

    public UsuarioSenhaException() {
        this.mensagem = "UsuarioLoginException";
    }

    public UsuarioSenhaException(final String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMessage() {
        return this.mensagem;
    }

}
