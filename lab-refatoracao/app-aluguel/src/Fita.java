package src;

public abstract class Fita {

  private String titulo;
  private int codigoDePreco;

  public abstract double calcularValor(int diasAluguel);

  public Fita(String titulo, int codigoDePreco) {
    this.titulo = titulo;
    this.codigoDePreco = codigoDePreco;
  }

  public String getTitulo() {
    return titulo;
  }

  public int getCodigoDePreco() {
    return codigoDePreco;
  }

  public void setCodigoDePreco(int codigoDePreco) {
    this.codigoDePreco = codigoDePreco;
  }

}
