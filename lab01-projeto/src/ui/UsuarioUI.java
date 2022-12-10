package ui;

import controller.usuario.UsuarioFacade;
import controller.usuario.command.*;
import entity.Usuario;

import java.util.List;
import java.util.Scanner;

public class UsuarioUI {

    private final Scanner sc = new Scanner(System.in);
    private final UsuarioFacade usuarioFacade;

    public UsuarioUI(final UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public void menu() {
        while (true) {
            int op = this.obterAcaoUsuario();

            if (op == 1) {
                this.cadastrarUsuario();
            } else if(op == 2) {
            	this.cadastrarUsuarioArquivo();
            } else if (op == 3) {
                this.listarUsuario();
            } else if (op == 4) {
                this.buscarUsuario();
            } else if (op == 5) {
                System.out.println("Implementar");
            } else if (op == 6) {
                break;
            } else if (op == 7) {
                System.out.println("1 - HTML");
                System.out.println("2 - PDF");
                
                int o = sc.nextInt();

                this.usuarioFacade.executarGeradorRelatorio(o);
            } else if (op == 8) {
                System.out.print("Informe o login do usuário que deseja atualizar: ");
                final String login = this.sc.next();
                
                System.out.print("Informe o novo nome do usuário: ");
                final String nome = this.sc.next();

                try {
                    final Command command = new AtualizarNomeCommand(login, nome);

                    this.usuarioFacade.executar(command);
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else if (op == 9) {
                try {
                    this.usuarioFacade.restore();
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            }

            this.sc.nextLine();
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
        System.out.println("8 - Atualizar nome usuário");
        System.out.println("9 - Restaurar para ultima versao");

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

        System.out.print("Informe o nome do usuário: ");
        final String nome = this.sc.next();

        final Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setLogin(login);

        try {
            final Command command = new SalvarCommand(usuario);

            this.usuarioFacade.executar(command);

            System.out.println("usuário cadastrado com sucesso.");
        } catch (final Exception ex) {
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
            this.usuarioFacade.adicionarDeArquivo(path);
        }
        catch(final Exception ex){
            ex.printStackTrace();
        }

        System.out.println("Usuário cadastrado com sucesso.");
    }

    @SuppressWarnings("unchecked")
    private void listarUsuario() {
        final Command command = new ListarCommand();

        final List<Usuario> usuarios;

        try {
            usuarios = (List<Usuario>) this.usuarioFacade.executar(command);

            System.out.println("LISTANDO TODOS OS usuário CADASTRADOS");

            for (final Usuario usuario : usuarios) {
                this.mostrarUsuario(usuario);

                System.out.println("------------------------------------");
            }
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    private void buscarUsuario() {
        System.out.println("---------------------------------------");
        System.out.print("Informe o login do usuário a ser buscado: ");
        final String login = this.sc.next();
        System.out.println("---------------------------------------");

        try {
            final Command command = new BuscarLoginCommand(login);

            final Usuario usuario = (Usuario) this.usuarioFacade.executar(command);

            System.out.println("---------------------------------------");
            System.out.println("usuário encontrado");
            System.out.println("---------------------------------------");

            this.mostrarUsuario(usuario);
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void mostrarUsuario(final Usuario usuario) {
        System.out.println("---------------------------------------");
        System.out.println("Login: " + usuario.getLogin());
        System.out.println("Senha: " + usuario.getSenha());
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("---------------------------------------");
    }

}
