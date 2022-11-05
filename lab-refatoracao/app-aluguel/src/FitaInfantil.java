package src;

public class FitaInfantil extends Fita {

    private double valorPadrao = 1.5;

    public FitaInfantil(String titulo) {
        super(titulo, FitaClassificacao.INFANTIL.getCodigo());
    }

    @Override
    public double calcularValor(int diasAluguel) {
        double valorTotal = valorPadrao;
        
        if (diasAluguel > 3) {
            valorTotal += (diasAluguel - 3) * 1.5;
        }
        
        return valorTotal;
    }
    
}
