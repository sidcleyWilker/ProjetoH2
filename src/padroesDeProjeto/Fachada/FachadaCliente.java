package padroesDeProjeto.Fachada;


import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.Proxy.ProxyDiciplina;
import padroesDeProjeto.Proxy.ProxyProfessor;

public class FachadaCliente implements FachadaIF{

	private ProxyProfessor professor = new ProxyProfessor();
	private ProxyDiciplina diciplina = new ProxyDiciplina();
	
	@Override
	public void addProfessor(String idProfessor, String nome)
			throws H2Exception {
		professor.add(idProfessor, nome);	
	}

	@Override
	public void alteraProfessor(String idProfessor, String novoNome)
			throws H2Exception {
		professor.alterar(idProfessor, novoNome);	
	}

	@Override
	public void removeProfessor(String matricula) throws H2Exception {
		professor.remover(matricula);
	}

	@Override
	public String getProfessor(String identificador) throws H2Exception {
		return professor.getToStringProfessor(identificador);
	}

	@Override
	public void addDisciplinaAoPeriodo(String identificadorDisciplina,
			String nomeDisciplina, int cargaHoraria, String identificadorCurso,
			String identificadorperiodo) throws H2Exception {
		
		diciplina.addDiciplina(identificadorDisciplina, nomeDisciplina, cargaHoraria, identificadorCurso, identificadorperiodo);	
	}

	@Override
	public void alteraDisciplina(String idCurso, String sigla, String atributo,
			String novoValor) throws H2Exception {
		
		diciplina.alteraDiciplina(idCurso, sigla, atributo, novoValor);
	}

	@Override
	public void removeDisciplina(String idCurso, String idDisciplina)
			throws H2Exception {
		
		diciplina.removeDiciplina(idCurso, idDisciplina);
	}

	@Override
	public String getDisciplina(String idCurso, String idDisciplina)
			throws H2Exception {
		return diciplina.toStringDiciplina(idCurso, idDisciplina);
	}

	@Override
	public void addSala(String idSala, String bloco) throws H2Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alteraSala(String idSala, String novoBloco) throws H2Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSala(String idSala) throws H2Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPeriodo(String identificadorPeriodo, String idCurso)
			throws H2Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePeriodo(String idCurso, String nomePeriodo)
			throws H2Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTurma(String idTurma, String idCurso,
			String identificadorProfessor, String identificadorDisciplina,
			String identificadorSala, String identificadorPeriodo)
			throws H2Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alteraTurma(String idTurma, String campo, String novoValor)
			throws H2Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerTurma(String idTurma) throws H2Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTurma(String idTurma) throws H2Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCurso(String identificadorCurso, String nome)
			throws H2Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarCurso(String identificador, String novoValor)
			throws H2Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCurso(String identificador) throws H2Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCurso(String idCurso) throws H2Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSala(String idSala) throws H2Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPeriodo(String idPeriodo, String idCurso)
			throws H2Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alocaTurmaAoHorario(String idTurma, String diaDaSemana,
			int horaInicio, int horafim) throws H2Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String desalocaTurmaDoHorario(String idTurma, String diaDaSemana,
			int horaInicio, int horaFim) throws H2Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHorario(String idTurma) throws H2Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTurmas(String diaDaSemana, int horaInicio, int horaFim)
			throws H2Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
