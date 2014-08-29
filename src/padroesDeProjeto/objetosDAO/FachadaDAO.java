package padroesDeProjeto.objetosDAO;

import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.factory.FactoryDAO;
import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.modelo.Modelo;

public class FachadaDAO {

	private FactoryDAO factoryDAO;
	
	public FachadaDAO(){
		this.factoryDAO = new FactoryDAO();
	
	}
	
	public void addProfessor(Modelo objectTypeModelo){
		factoryDAO.getObjectDAOModelo("professorDao").criar("professor", objectTypeModelo);	
	}


	public void alteraProfessor(String idProfessor, String novoNome){
		factoryDAO.getObjectDAOModelo("professorDao").atualizar("professor", idProfessor, novoNome);	
	}

	
	public void removeProfessor(String matricula){
		factoryDAO.getObjectDAOModelo("professorDao").remover("professor", matricula);
		
	}

	
	public String getProfessor(String identificador) {
		return ((ProfessorDAO) factoryDAO.getObjectDAOModelo("professorDao")).getProfessores().get(identificador).toString();
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
	public void addSala(Modelo objectTypeModelo){
		factoryDAO.getObjectDAOModelo("salaDao").criar("sala", objectTypeModelo);
	}


	public void alteraSala(String idSala, String novoBloco) {
		factoryDAO.getObjectDAOModelo("salaDao").atualizar("sala", idSala, novoBloco);	
	}


	public void removeSala(String idSala) {
		factoryDAO.getObjectDAOModelo("salaDao").remover("sala", idSala);
	}
	
	
	public String getSala(String idSala){
		return ((SalaDAO) factoryDAO.getObjectDAOModelo("salaDao")).getSalas().get(idSala).toString();
	}

	
	public void addPeriodo(String identificadorPeriodo, String idCurso) {

		
	}

	
	public void removePeriodo(String idCurso, String nomePeriodo){

		
	}

	
	public void addTurma(String idTurma, String idCurso,
			String identificadorProfessor, String identificadorDisciplina,
			String identificadorSala, String identificadorPeriodo){

		
	}

	
	public void alteraTurma(String idTurma, String campo, String novoValor){

		
	}

	
	public void removerTurma(String idTurma) {
	
		
	}

	public String getTurma(String idTurma){

		return null;
	}

	
	public void addCurso(Modelo objectTypeModelo){
		factoryDAO.getObjectDAOModelo("cursoDao").criar("sala", objectTypeModelo);
		
	}

	
	public void alterarCurso(String identificador, String novoValor){
		factoryDAO.getObjectDAOModelo("cursoDao").atualizar("curso", identificador, novoValor);
	}

	
	public void removeCurso(String identificador){
		factoryDAO.getObjectDAOModelo("cursoDao").remover("curso", identificador);
		
	}


	public String getCurso(String idCurso){
		return ((CursoDAO)factoryDAO.getObjectDAOModelo("cursoDao")).getCuros().get(idCurso).toString();
	}


	public String getPeriodo(String idPeriodo, String idCurso) {

		return null;
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
