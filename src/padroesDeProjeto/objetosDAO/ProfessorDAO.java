package padroesDeProjeto.objetosDAO;

import java.util.Map;

import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.util.Util;


public class ProfessorDAO extends ModeloDAO{
	
	public Map<String,Professor> getProfessores(){
		Util.bd.load();
		return Util.bd.getProfessores();
	}

}
