package src;

public class FitaNormal extends Fita {

    private double valorPadrao = 2.00;

    public FitaNormal(String titulo) {
        super(titulo, FitaClassificacao.NORMAL.getCodigo());
    }

    @Override
    public double calcularValor(int diasAluguel) {
        double valorTotal = valorPadrao;

        if (diasAluguel > 2) {
            valorTotal += (diasAluguel - 2) * 1.5;
        }

        return valorTotal;
    }
    
}
