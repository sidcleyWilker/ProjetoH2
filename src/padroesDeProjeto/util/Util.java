package padroesDeProjeto.util;


import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.bancoDeDados.BD;

public class Util {

	public static final BD bd = new BD();
	
	public static void verificaAtributo(String atributo) throws ExceptionParametroInvalido{
		if ( atributo == null){
			throw new ExceptionParametroInvalido("Atributo inválido");
		}
		if( !(atributo.matches("[a-zA-Zà-úÀ-Ú\\s .,!?:;_0-9]+"))){
			throw new ExceptionParametroInvalido("Atributo inválido");
		}
	}
}
