package src;

import java.util.*;

public class Cliente {

  private String nome;
  private Collection<Aluguel> fitasAlugadas = new ArrayList<>();

  public Cliente(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void adicionaAluguel(Aluguel aluguel) {
    fitasAlugadas.add(aluguel);
  }

  public String extrato() {
    final String fimDeLinha = System.getProperty("line.separator");
    
    double valorTotal = 0.0;
    
    int pontosDeAlugadorFrequente = 0;
    
    Iterator<Aluguel> alugueis = fitasAlugadas.iterator();
    
    String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
    
    while(alugueis.hasNext()) {
      double valorCorrente = 0.0;
      
      Aluguel cada = alugueis.next();

      valorCorrente += cada.calcularValor();
      
      pontosDeAlugadorFrequente++;
      
      pontosDeAlugadorFrequente += cada.adicionarPontoAluguelLancamento();

      // mostra valores para este Rent
      resultado += "\t" + cada.getFita().getTitulo() + "\t" + valorCorrente + fimDeLinha;
      
      valorTotal += valorCorrente;
    }
    
    // adiciona roda
    resultado += "Valor total devido: " + valorTotal + fimDeLinha;
    resultado += "Voce acumulou " + pontosDeAlugadorFrequente + " pontos de alugador frequente";
    
    return resultado;
  }

}
