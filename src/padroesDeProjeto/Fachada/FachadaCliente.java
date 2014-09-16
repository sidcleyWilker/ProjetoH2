package padroesDeProjeto.Fachada;


import padroesDeProjeto.Alocacao.GerenciaAlocacao;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.GerarPDF.GerarPDF;
import padroesDeProjeto.Proxy.ProxyCurso;
import padroesDeProjeto.Proxy.ProxyDiciplina;
import padroesDeProjeto.Proxy.ProxyPeriodo;
import padroesDeProjeto.Proxy.ProxyProfessor;
import padroesDeProjeto.Proxy.ProxySala;
import padroesDeProjeto.Proxy.ProxyTurma;

public class FachadaCliente implements FachadaIF{

	private ProxyProfessor professor = new ProxyProfessor();
	private ProxyDiciplina diciplina = new ProxyDiciplina();
	private ProxySala sala = new ProxySala();
	private ProxyCurso curso = new ProxyCurso();
	private ProxyPeriodo periodo = new ProxyPeriodo();
	private ProxyTurma turma = new ProxyTurma();
	private GerenciaAlocacao alocacao = new GerenciaAlocacao();
	private GerarPDF gerarPDF = new GerarPDF();
	
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
		
		sala.add(idSala, bloco);
	}

	@Override
	public void alteraSala(String idSala, String novoBloco) throws H2Exception {
		
		sala.altera(idSala, novoBloco);
	}

	@Override
	public void removeSala(String idSala) throws H2Exception {
		
		sala.remove(idSala);
	}
	
	@Override
	public String getSala(String idSala) throws H2Exception {

		return sala.getSala(idSala);
	}

	@Override
	public void addPeriodo(String identificadorPeriodo, String idCurso)
			throws H2Exception {
		
		periodo.add(identificadorPeriodo, idCurso);
	}

	@Override
	public void removePeriodo(String nomePeriodo,String idCurso)
			throws H2Exception {
		periodo.remove(nomePeriodo, idCurso);
		
	}

	@Override
	public void addTurma(String idTurma, String idCurso,
			String identificadorProfessor, String identificadorDisciplina,
			String identificadorSala, String identificadorPeriodo,int periodoAtual)
			throws H2Exception {
	
		turma.addTurma(idTurma, idCurso, identificadorProfessor,identificadorDisciplina,
				identificadorSala, identificadorPeriodo,periodoAtual);
	}

	@Override
	public void alteraTurma(String idTurma, String campo, String novoValor)
			throws H2Exception {
		
		turma.alteraTurma(idTurma, campo, novoValor);
	}

	@Override
	public void removerTurma(String idTurma) throws H2Exception {
		
		turma.removeTurma(idTurma);
	}

	@Override
	public String getTurma(String idTurma) throws H2Exception {
		
		return turma.getTurma(idTurma);
	}

	@Override
	public void addCurso(String identificadorCurso, String nome)
			throws H2Exception {
		
		curso.add(identificadorCurso, nome);
	}

	@Override
	public void alterarCurso(String identificador, String novoValor)
			throws H2Exception {
		curso.alterar(identificador, novoValor);
		
	}

	@Override
	public void removeCurso(String identificador) throws H2Exception {
		
		curso.remove(identificador);
	}

	@Override
	public String getCurso(String idCurso) throws H2Exception {
	
		return curso.getCurso(idCurso);
	}

	@Override
	public String getPeriodo(String idPeriodo, String idCurso)
			throws H2Exception {
		
		return periodo.getPeriodo(idPeriodo,idCurso);
	}

	@Override
	public String alocaTurmaAoHorario(String idTurma, String diaDaSemana,
			int horaInicio, int horafim) throws H2Exception {
		
		return alocacao.alocaTurmaAoHorario(idTurma, diaDaSemana, horaInicio, horafim);
	}

	@Override
	public String desalocaTurmaDoHorario(String idTurma, String diaDaSemana,
			int horaInicio, int horaFim) throws H2Exception {
		
		return alocacao.desalocaTurmaDoHorario(idTurma, diaDaSemana, horaInicio, horaFim);
	}

	@Override
	public String getHorario(String idTurma) throws H2Exception {
		
		return alocacao.getHorario(idTurma);
	}

	@Override
	public String getTurmas(String diaDaSemana, int horaInicio, int horaFim)
			throws H2Exception {
		
		return alocacao.getTurmas(diaDaSemana, horaInicio, horaFim);
	}

	@Override
	public String salvaHorario(String nomeDoArquivo) {
		
		return null;
	}

}
