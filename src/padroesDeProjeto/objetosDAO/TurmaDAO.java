package padroesDeProjeto.objetosDAO;

import java.util.Map;

import padroesDeProjeto.modelo.Turma;
import padroesDeProjeto.util.Util;

public class TurmaDAO {

	public void criar(Turma turma){
		Util.bd.load();
		Util.bd.getTurmas().put(turma.getId(), turma);
		Util.bd.salvar();
	}

	public Map<String,Turma> getTurmas(){
		Util.bd.load();
		return Util.bd.getTurmas();
	}
	
	public void alterar(){
		
	}
	
	public void remove(String key){
		Util.bd.load();
		Util.bd.getTurmas().remove(key);
		Util.bd.salvar();
	}
}
