package padroesDeProjeto.objetosDAO;

import java.util.Map;

import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.util.Util;

public class PeriodoDAO {

	/**
	 * carega, adiciona e salva um periodo ao sistema
	 * @param periodo - objeto do tipo periodo
	 */
	public void cria(Periodo periodo){
		Util.bd.load();
		Util.bd.getPeriodos().put(periodo.getId()+"-"+periodo.getCurso().getId(), periodo);
		Util.bd.salvar();
	}
	
	/**
	 * carega e retorna todos os periodos que estão no sistema
	 * @return - o map contendo todos os periodos
	 */
	public Map<String,Periodo> getPeriodos(){
		Util.bd.load();
		return Util.bd.getPeriodos();
	}
	
	/**
	 * carega, remove um periodo e salva 
	 * @param key
	 */
	public void remove(String key){
		Util.bd.load();
		Util.bd.getPeriodos().remove(key);
		Util.bd.salvar();
	}
}
