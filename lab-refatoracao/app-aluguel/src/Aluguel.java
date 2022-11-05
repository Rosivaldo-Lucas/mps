package src;

public class Aluguel {

  private Fita fita;
  private int diasAlugada;

  public double calcularValor() {
    return this.fita.calcularValor(diasAlugada);
  }

  public int adicionarPontoAluguelLancamento() {
    int pontosDeAlugadorFrequente = 0;

    if (fita.getCodigoDePreco() == FitaClassificacao.LANCAMENTO.getCodigo() && diasAlugada > 1) {
      pontosDeAlugadorFrequente++;
    }

    return pontosDeAlugadorFrequente;
  }

  public Aluguel(Fita fita, int diasAlugada) {
    this.fita = fita;
    this.diasAlugada = diasAlugada;
  }

  public Fita getFita() {
    return fita;
  }

  public int getDiasAlugada() {
    return diasAlugada;
  }

}
