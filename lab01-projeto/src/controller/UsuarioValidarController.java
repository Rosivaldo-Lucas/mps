package controller;

import exception.UsuarioLoginException;
import exception.UsuarioSenhaException;

public class UsuarioValidarController {
    
    String[] letrasL = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "ç", "z", "x", "c", "v", "b", "n", "m"};

    String[] letrasU = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Ç", "Z", "X", "C", "V", "B", "N", "M"};

    String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public void validarLogin(final String login) throws UsuarioLoginException {
        if (login.equals(null)) {
            throw new UsuarioLoginException("Login não pode ser vazio.");
        }
        
        if (login.length() > 12 || login.length() == 0) {
            throw new UsuarioLoginException("Login não pode ser vazio e deve ter 12 caracteres no máximo.");
        }

        if (login.matches("[0-9]+")) {
            throw new UsuarioLoginException("Login não conter números");
        }
    }

    public void validarSenha(final String senha) throws UsuarioSenhaException {
        if (senha.equals(null)) {
            throw new UsuarioSenhaException("Senha não pode ser vazio.");
        }
        
        if (senha.length() < 8 || senha.length() > 20) {
            throw new UsuarioSenhaException("Senha deve ter no mínomo 8 caracteres e no máximo 20 caracteres.");
        }

        int quantidadeNumerosSenha = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (senha.contains(numeros[i])) {
                quantidadeNumerosSenha++;
            }
        }

        if (quantidadeNumerosSenha < 2) {
            throw new UsuarioSenhaException("Senha deve conter no mínimo 2 números.");
        }

        if (quantidadeNumerosSenha == senha.length()) {
            throw new UsuarioSenhaException("Senha deve conter letras também.");
        }

    }

}
