package padroesDeProjeto.objetosDAO;

import java.util.Map;

import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.util.Util;

public class PeriodoDAO {

	public void cria(Periodo periodo){
		Util.bd.load();
		Util.bd.getPeriodos().put(periodo.getId()+"-"+periodo.getCurso().getId(), periodo);
		Util.bd.salvar();
	}
	
	public Map<String,Periodo> getPeriodos(){
		Util.bd.load();
		return Util.bd.getPeriodos();
	}
	
	public void remove(String key){
		Util.bd.load();
		Util.bd.getPeriodos().remove(key);
		Util.bd.salvar();
	}
}
