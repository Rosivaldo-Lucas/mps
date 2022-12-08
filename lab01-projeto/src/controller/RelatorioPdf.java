package controller;

import java.util.List;

import entity.Usuario;

public class RelatorioPdf extends GerarRelatorioTemplate {

    @Override
    public void montarRelatorio(final List<Usuario> usuarios) {
        System.out.println("RELATÓRIOS USUÁRIOS PDF");
        
        for (final Usuario usuario : usuarios) {
            System.out.print("nome: ");
            System.out.println(usuario.getNome());
    
            System.out.print("login: ");
            System.out.println(usuario.getLogin());
            
            System.out.print("tipo usuário: ");
            System.out.println(usuario.getTipoUsuario());
        }
    }
    
}
