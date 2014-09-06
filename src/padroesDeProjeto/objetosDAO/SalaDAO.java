package padroesDeProjeto.objetosDAO;

import java.util.Map;

import padroesDeProjeto.modelo.Sala;
import padroesDeProjeto.util.Util;

public class SalaDAO extends ModeloDAO {

	/**
	 * carega e retorna todos as salas cadastradas no sistema
	 * @return
	 */
	public Map<String,Sala> getSalas(){
		Util.bd.load();
		return Util.bd.getSalas();
	}
}
