package padroesDeProjeto.objetosDAO;

import java.util.Map;

import padroesDeProjeto.modelo.Sala;
import padroesDeProjeto.util.Util;

public class SalaDAO extends ModeloDAO {

	public Map<String,Sala> getSalas(){
		Util.bd.load();
		return Util.bd.getSalas();
	}
}
