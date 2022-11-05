package src;

public class FitaLancamento extends Fita {

    public FitaLancamento(String titulo) {
        super(titulo, FitaClassificacao.LANCAMENTO.getCodigo());
    }

    @Override
    public double calcularValor(int diasAluguel) {
        double valorTotal = diasAluguel * 3;
        
        return valorTotal;
    }
    
}
