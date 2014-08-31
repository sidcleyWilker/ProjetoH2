package padroesDeProjeto.util;

import padroesDeProjeto.BancoDeDados.BD;
import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.factory.FactoryDAO;
import padroesDeProjeto.factory.FactoryObject;
import padroesDeProjeto.objetosDAO.FachadaDAO;
/**
 * class que vai ter metodos e atributos que são util para o projeto e atributos que são criados 
 * unicamente e metodos que só presiza de um
 */
public class Util {

	public static final BD bd = new BD();
	public static final FachadaDAO fachadaDao = new FachadaDAO();
	public static final FactoryDAO factoryDao = new FactoryDAO();
	public static final FactoryObject factoryObject = new FactoryObject();
	
	/**
	 * verifica se atributo e vazio ou nullo, recebe um array de atributos indefinido
	 * pode conter um N atributos
	 * @param atributo  - array de atributos 
	 * @throws ExceptionParametroInvalido - atributo invalido
	 */
	public static void verificaAtributo(String ... atributo ) throws ExceptionParametroInvalido{
		for (String string : atributo) {
			if ( string == null){
				throw new ExceptionParametroInvalido();
			}
			if( !(string.matches("[a-zA-Zà-úÀ-Ú\\s .,!?:;_0-9]+"))){
				throw new ExceptionParametroInvalido();
			}
		}
	}
	
	public static boolean convert(String valor) throws ExceptionParametroInvalido{
		try{
			@SuppressWarnings("unused")
			int novoValor = Integer.parseInt(valor);
		}catch( NumberFormatException e){
			throw new ExceptionParametroInvalido();
		}
		return true;
	}
}
