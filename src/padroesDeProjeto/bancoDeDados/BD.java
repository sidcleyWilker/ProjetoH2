package padroesDeProjeto.bancoDeDados;

import java.util.HashMap;
import java.util.Map;

import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.modelo.Sala;

public class BD {
	
	public BD(){
		
	}

	private Map<String,Professor> professores = new HashMap<>();
	private Map<String,Curso> cursos = new HashMap<>();
	private Map<String,Sala> salas = new HashMap<>();
	
	public Map<String, Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(Map<String, Professor> professores) {
		this.professores = professores;
	}
	
	
	
	public Map<String, Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Map<String, Curso> cursos) {
		this.cursos = cursos;
	}

	public Map<String, Sala> getSalas() {
		return salas;
	}

	public void setSalas(Map<String, Sala> salas) {
		this.salas = salas;
	}

	/**
	 * metodo que salva a class BD em um arquivo xml
	 */
	public void salvar(){
		IO.getInstance().save(this);
	}
	
	/**
	 * metodo que recupera do arquivo uma class BD e adiciona a uma variavel
	 */
	public void load(){
		BD bd = IO.getInstance().recover();
	}
}
