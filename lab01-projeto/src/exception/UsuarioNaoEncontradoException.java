package exception;

public class UsuarioNaoEncontradoException extends Exception {
    
    private final String mensagem;

    public UsuarioNaoEncontradoException() {
        this.mensagem = "UsuarioLoginException";
    }

    public UsuarioNaoEncontradoException(final String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMessage() {
        return this.mensagem;
    }

}
