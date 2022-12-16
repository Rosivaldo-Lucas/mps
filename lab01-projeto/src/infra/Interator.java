package infra;

public interface Interator {
    boolean hasnext();
    Object next();
}

class Interador implements Interator{

    UsuarioDao[] usuariodao;

    int posicao = 0;

    public Interador(UsuarioDao[] usuariodao){
        this.usuariodao = usuariodao;
    }

    public Object next(){
        UsuarioDao users = usuariodao[posicao];
        posicao++;

        return users;
    }

    public boolean hasnext(){
        
        if (posicao >= usuariodao.length || usuariodao[posicao] == null){
            return false;
        }
        else{
          return true;  
        }
    }


}
