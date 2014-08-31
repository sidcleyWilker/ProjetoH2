package padroesDeProjeto.BancoDeDados;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * class de <code> Manipulação de arquivos</code>. A classe I/O (Input,Output)"
 * do portugues E/S (Entrada : Saida , Ler/Escrevre), vai ser responsavel por"
 * <i>gravar informações em arquibos XML e recuperar essas informações.</i> <br>
 * </br> nesta classes usarei o <b>padrão singletom </b>
 * 
 * @author Sidcley
 * 
 */
public class IO {

	public static IO io;

	private IO() {

	}

	public static IO getInstance() {
		if (io == null) {
			io = new IO();
		}
		return io;
	}

	/**
	 * metodo <b>save</b> vai salvar um objeto do tipo <i>BD</i> que siguinifica banco de dados
	 * dentro de um arquivo xml
	 * 
	 * @param object objeto do tipo BD
	 */
	
	public void save(BD object) {
		try {
			FileOutputStream fos = new FileOutputStream("./file/bd.xml");  
            XMLEncoder en = new XMLEncoder(fos);  
            en.writeObject(object);  
            en.close();  
            fos.close();              
        } catch (Exception e){  
            System.out.println("Erro: " + e.getMessage());    
        }  
	}


	/**
	 * metodo recover vai retorna um objeto do tipo BD que esta dentro de um arquivo xml
	 *
	 * @return objeto do tipo BD 
	 */
	@SuppressWarnings("resource")
	public BD recover() {
		FileInputStream fi = null;
		XMLDecoder decoder = null;

		try {
			fi = new FileInputStream("./file/bd.xml");
			decoder = new XMLDecoder(fi);
			return (BD) decoder.readObject();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
