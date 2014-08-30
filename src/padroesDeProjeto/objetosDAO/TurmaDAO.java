package padroesDeProjeto.objetosDAO;

import java.util.Map;

import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.modelo.Sala;
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
	
	public void alterar(String id,String campo,Object novovalor){
		Util.bd.load();
		if(campo.equals("professor")){
			Util.bd.getTurmas().get(id).setProfessor((Professor)novovalor);
		}else if(campo.equals("diciplina")){
			Util.bd.getTurmas().get(id).setDiciplina((Diciplina)novovalor);
		}else if(campo.equals("sala")){
			Util.bd.getTurmas().get(id).setSala((Sala)novovalor);
		}else if(campo.equals("periodo")){
			Util.bd.getTurmas().get(id).setPeriodo((Periodo) novovalor);
		}
		Util.bd.salvar();
	}
	
	public void remove(String key){
		Util.bd.load();
		Util.bd.getTurmas().remove(key);
		Util.bd.salvar();
	}
}
