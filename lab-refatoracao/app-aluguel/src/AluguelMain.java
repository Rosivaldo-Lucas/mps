package src;

public class AluguelMain {
  
  public static void main(String[] args) {
    final Cliente c1 = new Cliente("Juliana");

    c1.adicionaAluguel(new Aluguel(new FitaNormal("O Exorcista                     "), 3));
    c1.adicionaAluguel(new Aluguel(new FitaNormal("Men in Black                    "), 2));
    c1.adicionaAluguel(new Aluguel(new FitaLancamento("Jurassic Park III           "), 3));
    c1.adicionaAluguel(new Aluguel(new FitaLancamento("Planeta dos Macacos         "), 4));
    c1.adicionaAluguel(new Aluguel(new FitaInfantil("Pateta no Planeta dos Macacos "), 10));
    c1.adicionaAluguel(new Aluguel(new FitaInfantil("O Rei Leao                    "), 30));

    System.out.println(c1.extrato());
  }
  
}
