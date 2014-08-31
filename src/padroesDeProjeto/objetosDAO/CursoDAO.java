package padroesDeProjeto.objetosDAO;

import java.util.Map;

import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.util.Util;

/**
 * class que faz a função de adicionar, alterar, remover e retorna os cursos do sistema
 * @author Sidcley
 *
 */
public class CursoDAO extends ModeloDAO{

	/**
	 * carrega e retorna os cursos cadastrados no sistema
	 * @return
	 */
	public Map<String,Curso> getCuros(){
		Util.bd.load();
		return Util.bd.getCursos();
	}
}
