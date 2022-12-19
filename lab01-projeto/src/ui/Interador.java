package ui;

import java.util.ArrayList;
import java.util.List;
import entity.Usuario;
import infra.UsuarioDao;


public class Interador implements Interator{

    Usuario[] usuario;

    int posicao = 0;

    public Interador(Usuario[] usuario){
        this.usuario = usuario;
    }

    public Usuario next(){

        Usuario users = usuario[posicao];
        posicao++;

        return users;
    }

    public boolean hasnext(){
        
        if (posicao >= usuario.length || usuario[posicao] == null){
            return false;
        }
        else{
          return true;  
        }
    }


}
