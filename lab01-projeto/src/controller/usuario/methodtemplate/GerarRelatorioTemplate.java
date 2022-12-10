package controller.usuario.methodtemplate;

import java.util.List;

import entity.Usuario;

public abstract class GerarRelatorioTemplate {

    public void gerarRelatorio(final List<Usuario> usuarios, final String tipoRelatorio) {
        this.cabecalho(tipoRelatorio);

        this.montarRelatorio(usuarios);

        this.rodape();
    }

    public abstract void montarRelatorio(final List<Usuario> usuarios);

    private void cabecalho(final String tipoRelatorio) {
        System.out.println("Relatório do tipo " + tipoRelatorio);
        System.out.println("Relatório de usuários do sistema");
        System.out.println("--------------------------------------");
    }

    private void rodape() {
        System.out.println("--------------------------------------");
        System.out.println("Fim do relatório");
    }

}
