package infra;

public interface Dao {
    
    void salvar(final Object object);

    Object buscarPorNome(final String nome);

}
