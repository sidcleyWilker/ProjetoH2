package padroesDeProjeto.objetosDAO;

import java.util.Map;

import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.util.Util;

public class CursoDAO extends ModeloDAO{

	public Map<String,Curso> getCuros(){
		Util.bd.load();
		return Util.bd.getCursos();
	}
}
