package ui;

import java.util.List;
import java.util.Scanner;

import controller.UsuarioController;
import entity.Usuario;
import exception.UsuarioLoginException;
import exception.UsuarioNaoEncontradoException;
import exception.UsuarioSenhaException;

public class UsuarioUI {

    final Scanner sc = new Scanner(System.in);

    private final UsuarioController usuarioController;

    public UsuarioUI(final UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public void menu() {
        while (true) {
            final int op = this.obterAcaoUsuario();

            if (op == 1) {
                this.cadastrarUsuario();
            } else if(op == 2) {
            	this.cadastrarUsuarioArquivo();
            } else if (op == 3) {
                this.listarUsuario();
            } else if (op == 4) {
                this.buscarUsuario();
            } else if (op == 5) {
                this.usuarioController.deletar();
            } else if (op == 6) {
                break;
            } else if (op == 7) {

                System.out.println("1 - HTML");
                System.out.println("2 - PDF");
                
                int o = sc.nextInt();

                if (o == 1) {
                    this.usuarioController.obterRelatorio("html");
                } else if (o == 2) {
                    this.usuarioController.obterRelatorio("pdf");
                }

            }
        }

        sc.close();
    }

    private int obterAcaoUsuario() {
        System.out.println("MENU USUÁRIO");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Cadastrar usuário por arquivo");
        System.out.println("3 - Listar usuário");
        System.out.println("4 - Buscar usuário");
        System.out.println("5 - Deletar usuário");
        System.out.println("6 - Sair do programa");
        System.out.println("7 - Escolher relatório");

        final int op = this.sc.nextInt();

        return op;
    }

    private void cadastrarUsuario() {
        System.out.println("---------------------------------------");
        System.out.println("CADASTRO DE USUÁRIO");
        System.out.println("---------------------------------------");
            
        System.out.print("Informe o login do usuário: ");
        final String login = this.sc.next();

        System.out.print("Informe a senha do usuário: ");
        final String senha = this.sc.next();

        try {
            this.usuarioController.adicionar(login, senha);

            System.out.println("usuário cadastrado com sucesso.");
        } catch (final UsuarioLoginException ex) {
            System.out.println(ex.getMessage());
        } catch (final UsuarioSenhaException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void cadastrarUsuarioArquivo() {
        System.out.println("---------------------------------------");
        System.out.println("CADASTRO DE usuário");
        System.out.println("---------------------------------------");
            
        System.out.print("Informe o caminho do arquivo: ");
        final String path = this.sc.next();
        try {
        this.usuarioController.adicionarDeArquivo(path);
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        System.out.println("UsuÃ¡rio cadastrado com sucesso.");
    }
    
    private void listarUsuario() {
        final List<Usuario> usuarios = this.usuarioController.listar();        
    
        System.out.println("LISTANDO TODOS OS usuário CADASTRADOS");

        for (final Usuario usuario : usuarios) {
            this.mostrarUsuario(usuario);
            System.out.println("------------------------------------");
        }
    }

    private void buscarUsuario() {
        System.out.println("---------------------------------------");
        System.out.print("Informe o login do usuário a ser buscado: ");
        final String login = this.sc.next();
        System.out.println("---------------------------------------");

        try {
            final Usuario usuario = this.usuarioController.buscar(login);

            System.out.println("---------------------------------------");
            System.out.println("usuário encontrado");
            System.out.println("---------------------------------------");
            this.mostrarUsuario(usuario);
        } catch (final UsuarioNaoEncontradoException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void mostrarUsuario(final Usuario usuario) {
        System.out.println("---------------------------------------");
        System.out.println("Login: " + usuario.getLogin());
        System.out.println("Senha: " + usuario.getSenha());
        System.out.println("---------------------------------------");
    }

}
