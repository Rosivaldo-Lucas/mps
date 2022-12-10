package controller.usuario.adapter;

import java.util.Scanner;
import entity.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UsuarioAdapterController {
	
	public ArrayList<Usuario> getFromArchive(String path){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		String[] array = new String[3];
		
		try {
			File ler = new File(path);
	    	
			Scanner scanner = new Scanner(ler); 
	    	
			while(scanner.hasNext()) { 
	    		array = scanner.nextLine().split(";"); 
	    		
				Usuario usuario = new Usuario();
	    		usuario.setLogin(array[0]);
	    		usuario.setSenha(array[1]);
	    		usuarios.add(usuario);
	    	}
			
			scanner.close();
		} catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
		return usuarios;
	}
}
