package controller.usuario.methodtemplate;

import java.util.List;

import controller.usuario.methodtemplate.GerarRelatorioTemplate;
import entity.Usuario;

public class RelatorioHtml extends GerarRelatorioTemplate {

    @Override
    public void montarRelatorio(final List<Usuario> usuarios) {
        System.out.println("<h1>RELATÓRIOS USUÁRIOS HTML</h1>");
        
        for (final Usuario usuario : usuarios) {
            System.out.print("<strong>nome: </strong>");
            System.out.println(usuario.getNome());
    
            System.out.print("<strong>login: </strong>");
            System.out.println(usuario.getLogin());
            
            System.out.print("<strong>tipo usuário: </strong>");
            System.out.println(usuario.getTipoUsuario());
        }
    }
    
}
