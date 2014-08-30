package padroesDeProjeto.BancoDeDados;

import java.util.HashMap;
import java.util.Map;

import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.modelo.Sala;
import padroesDeProjeto.modelo.Turma;

/**
 * class bd vai representar um o esquema de um banco de dados, ele é que vai conter todos os dados 
 * de todos os objetos que seja para cadastrado no sistema
 * @author Sidcley
 *
 */
public class BD {
	
	public BD(){
		
	}

	private Map<String,Professor> professores = new HashMap<>();
	private Map<String,Curso> cursos = new HashMap<>();
	private Map<String,Sala> salas = new HashMap<>();
	private Map<String,Diciplina> diciplinas = new HashMap<>();
	private Map<String,Periodo> periodos = new HashMap<>();
	private Map<String,Turma> turmas = new HashMap<>();
	
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

	public Map<String, Diciplina> getDiciplinas() {
		return diciplinas;
	}

	public void setDiciplinas(Map<String, Diciplina> diciplinas) {
		this.diciplinas = diciplinas;
	}
	
	public Map<String, Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(Map<String, Periodo> periodos) {
		this.periodos = periodos;
	}

	public Map<String, Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Map<String, Turma> turmas) {
		this.turmas = turmas;
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
		this.professores = bd.getProfessores();
		this.cursos = bd.getCursos();
		this.salas = bd.getSalas();
		this.diciplinas = bd.getDiciplinas();
		this.periodos = bd.getPeriodos();
		this.turmas = bd.getTurmas();
	}
}
