package padroesDeProjeto.objetosDAO;

import padroesDeProjeto.factory.FactoryDAO;
import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.modelo.Sala;
import padroesDeProjeto.modelo.Turma;

public class FachadaDAO {

	private FactoryDAO factoryDAO;
	
	public FachadaDAO(){
		this.factoryDAO = new FactoryDAO();
	
	}
	
	public void addProfessor(Professor professor){
		factoryDAO.getProfessorDao().criar("professor", professor);
	}


	public void alteraProfessor(String idProfessor, String novoNome){
		factoryDAO.getProfessorDao().atualizar("professor", idProfessor, novoNome);	
	}

	
	public void removeProfessor(String matricula){
		factoryDAO.getProfessorDao().remover("professor", matricula);
		
	}

	
	public String getProfessor(String identificador) {
		return factoryDAO.getProfessorDao().getProfessores().get(identificador).toString();
	}

	
	public void addDisciplinaAoPeriodo(Diciplina diciplina) {
		factoryDAO.getDiciplinaDao().criar(diciplina);
	}

	
	public void alteraDisciplina(String keyDiciplina, String atributo,String novoValor){
		factoryDAO.getDiciplinaDao().atualizar(keyDiciplina, atributo, novoValor);
	}

	
	public void removeDisciplina(String key){
		factoryDAO.getDiciplinaDao().remove(key);
	}


	public String getDisciplina(String key){
		return factoryDAO.getDiciplinaDao().getDiciplinas().get(key).toString();
	}

	/**
	 * 
	 * @param objectTypeModelo
	 */
	public void addSala(Sala sala){
		factoryDAO.getSalaDao().criar("sala", sala);
	}


	public void alteraSala(String idSala, String novoBloco) {
		factoryDAO.getSalaDao().atualizar("sala", idSala, novoBloco);	
	}


	public void removeSala(String idSala) {
		factoryDAO.getSalaDao().remover("sala", idSala);
	}
	
	
	public String getSala(String idSala){
		return factoryDAO.getSalaDao().getSalas().get(idSala).toString();
	}

	
	public void addPeriodo(Periodo periodo) {
		factoryDAO.getPeriodoDao().cria(periodo);
	}

	
	public void removePeriodo(String key){
		factoryDAO.getPeriodoDao().remove(key);
	}

	public String getPeriodo(String key) {
		return factoryDAO.getPeriodoDao().getPeriodos().get(key).toString();
	}
	
	
	public void addTurma(Turma turma){
		factoryDAO.getTurmaDao().criar(turma);
		
	}

	
	public void alteraTurma(String idTurma, String campo, Object novoValor){
		factoryDAO.getTurmaDao().alterar(idTurma, campo, novoValor);
	}

	
	public void removerTurma(String idTurma) {
		factoryDAO.getTurmaDao().remove(idTurma);
	}

	public String getTurma(String idTurma){
		return factoryDAO.getTurmaDao().getTurmas().get(idTurma).toString();
	}

	
	public void addCurso(Curso curso){
		factoryDAO.getCursoDao().criar("curso", curso);
		
	}

	
	public void alterarCurso(String identificador, String novoValor){
		factoryDAO.getCursoDao().atualizar("curso", identificador, novoValor);
	}

	
	public void removeCurso(String identificador){
		factoryDAO.getCursoDao().remover("curso", identificador);
		
	}


	public String getCurso(String idCurso){
		return factoryDAO.getCursoDao().getCuros().get(idCurso).toString();
	}

	public String alocaTurmaAoHorario(String idTurma, String diaDaSemana,
			int horaInicio, int horafim){
		
		return null;
	}


	public String desalocaTurmaDoHorario(String idTurma, String diaDaSemana,int horaInicio, int horaFim) {

		return null;
	}

	
	public String getHorario(String idTurma)  {
	
		return null;
	}
	
	public String getTurmas(String diaDaSemana, int horaInicio, int horaFim){

		return null;
	}

}
