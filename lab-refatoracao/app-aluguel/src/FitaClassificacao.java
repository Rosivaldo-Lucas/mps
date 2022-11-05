package src;

public enum FitaClassificacao {
    
    NORMAL(0),
    LANCAMENTO(1),
    INFANTIL(2);

    private final int codigo;

    FitaClassificacao(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

}
