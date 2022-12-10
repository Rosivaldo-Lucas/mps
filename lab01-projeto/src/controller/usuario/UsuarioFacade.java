package controller.usuario;

import controller.usuario.command.Command;
import controller.usuario.memento.UsuarioCaretaker;
import controller.usuario.memento.UsuarioMemento;
import controller.usuario.memento.UsuarioOriginator;
import controller.usuario.methodtemplate.GerarRelatorioTemplate;
import controller.usuario.methodtemplate.RelatorioHtml;
import controller.usuario.methodtemplate.RelatorioPdf;
import infra.UsuarioDao;
import infra.UsuarioDaoImpl;

public class UsuarioFacade {

  private final UsuarioDao usuarioDao;

  public UsuarioFacade() {
    this.usuarioDao = new UsuarioDaoImpl();
  }

  public Object executar(final Command command) throws Exception {
    final Object usuario = command.execute(this.usuarioDao);

    return usuario;
  }

  public void executarGeradorRelatorio(final int tipo) {
    final GerarRelatorioTemplate gerarRelatorioTemplate;

    String tipoRelatorio = "";

    if (tipo == 1) {
      gerarRelatorioTemplate = new RelatorioHtml();

      tipoRelatorio = "html";
    } else {
      gerarRelatorioTemplate = new RelatorioPdf();

      tipoRelatorio = "pdf";
    }

    gerarRelatorioTemplate.gerarRelatorio(this.usuarioDao.listar(), tipoRelatorio);
  }

  public void adicionarDeArquivo(final String path) throws Exception {

  }

  public void restore() throws Exception {
    final UsuarioOriginator usuarioOriginator = new UsuarioOriginator();
    final UsuarioCaretaker usuarioCaretaker = new UsuarioCaretaker();

    
  }

}
