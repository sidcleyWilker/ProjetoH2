package padroesDeProjeto.util;

import padroesDeProjeto.BancoDeDados.BD;
import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.factory.FactoryDAO;
import padroesDeProjeto.factory.FactoryObject;
import padroesDeProjeto.objetosDAO.FachadaDAO;
/**
 * class que vai ter metodos e atributos que s�o util para o projeto e atributos que s�o criados 
 * unicamente e metodos que s� presiza de um
 */
public class Util {

	public static final BD bd = new BD();
	public static final FachadaDAO fachadaDao = new FachadaDAO();
	public static final FactoryDAO factoryDao = new FactoryDAO();
	public static final FactoryObject factoryObject = new FactoryObject();
	
	/**
	 * verifica se atributo e vazio ou nullo
	 * @param atributo  - atributo a ser verificado
	 * @throws ExceptionParametroInvalido - atributo invalido
	 */
	public static void verificaAtributo(String atributo) throws ExceptionParametroInvalido{
		if ( atributo == null){
			throw new ExceptionParametroInvalido("Atributo inv�lido");
		}
		if( !(atributo.matches("[a-zA-Z�-��-�\\s .,!?:;_0-9]+"))){
			throw new ExceptionParametroInvalido("Atributo inv�lido");
		}
	}
	
	public static boolean convert(String valor) throws ExceptionParametroInvalido{
		try{
			@SuppressWarnings("unused")
			int novoValor = Integer.parseInt(valor);
		}catch( NumberFormatException e){
			throw new ExceptionParametroInvalido("Atributo invalido");
		}
		return true;
	}
}
