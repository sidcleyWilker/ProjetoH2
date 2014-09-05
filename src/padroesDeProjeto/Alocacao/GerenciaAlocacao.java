package padroesDeProjeto.Alocacao;

import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.Exception.ExceptionTurmaNaoAlocada;
import padroesDeProjeto.Exception.ExceptionTurmaNaoCadastrada;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.util.Util;
import padroesDeProjeto.util.VerificadorDeObjetos;

/**
 * class vai gerencia o funcionamento da alocação da desalocação de obter o
 * horario de uma turma e as turmas de uma semana
 * 
 * @author Sidcley
 * 
 */
public class GerenciaAlocacao {

	private VerificadorDeObjetos verificador;
	private Horario horario;

	public GerenciaAlocacao() {
		verificador = new VerificadorDeObjetos();
		this.horario = new Horario();
	}

	/**
	 * metodo que aloca uma turma em um determinado horario em um dia da semana.
	 * metodo tambem verifica se existe um choque de horario, para isso
	 * verica-se o dia em que o usuario deseja alocar a turma e o intervalo de
	 * tempo, antes de fazer o processo e recuperado do banco de dados os dados que estavam salvos
	 * e apos fazer o processo e salvado de novo 
	 * 
	 * @param idTurma
	 *            - identificador da turma
	 * @param diaDaSemana
	 *            - o dia da semana
	 * @param horaInicio
	 *            - a hora de inicio da aula
	 * @param horafim
	 *            - a hora do fim da aula
	 * @return - o choque de horario se houver
	 * @throws Exception
	 *             - parametros invalidos
	 */
	public String alocaTurmaAoHorario(String idTurma, String diaDaSemana,
			int horaInicio, int horafim) throws Exception {
		verificadorDeAtributos(idTurma, diaDaSemana, horaInicio, horafim);
		horario.caregarHorario();
		String choque = "";

		if (diaDaSemana.equals("segunda")) {
			for (Alocacao a : horario.getSegunda().values()) {
				if ((horaInicio >= a.getHoraIni() || horaInicio < a
						.getHoraFim())
						|| (a.getHoraFim() < horafim || a.getHoraIni() >= horaInicio)) {
					choque += "Choque na segunda com - " + a.toString();
					horario.getSegunda().put(idTurma,new Alocacao(Util.factoryDao.getTurmaDao().getTurmas().get(idTurma), diaDaSemana,horaInicio, horafim));
				}
			}
		} else if (diaDaSemana.equals("terca")) {
			for (Alocacao a : horario.getTerca().values()) {
				if ((horaInicio >= a.getHoraIni() || horaInicio < a
						.getHoraFim())
						|| (a.getHoraFim() < horafim || a.getHoraIni() >= horaInicio)) {
					choque += "Choque com - " + a.toString();
					horario.getSegunda().put(idTurma,new Alocacao(Util.factoryDao.getTurmaDao().getTurmas().get(idTurma), diaDaSemana,horaInicio, horafim));
				}
			}
		} else if (diaDaSemana.equals("quarta")) {
			for (Alocacao a : horario.getQuarta().values()) {
				if ((horaInicio >= a.getHoraIni() || horaInicio < a
						.getHoraFim())
						|| (a.getHoraFim() < horafim || a.getHoraIni() >= horaInicio)) {
					choque += "Choque com - " + a.toString();
					horario.getSegunda().put(idTurma,new Alocacao(Util.factoryDao.getTurmaDao().getTurmas().get(idTurma), diaDaSemana,horaInicio, horafim));
				}
			}
		} else if (diaDaSemana.equals("quinta")) {
			for (Alocacao a : horario.getQuinta().values()) {
				if ((horaInicio >= a.getHoraIni() || horaInicio < a
						.getHoraFim())
						|| (a.getHoraFim() < horafim || a.getHoraIni() >= horaInicio)) {
					choque += "Choque com - " + a.toString();
					horario.getSegunda().put(idTurma,new Alocacao(Util.factoryDao.getTurmaDao().getTurmas().get(idTurma), diaDaSemana,horaInicio, horafim));
				}
			}
		} else if (diaDaSemana.equals("sexta")) {
			for (Alocacao a : horario.getSexta().values()) {
				if ((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
						|| (a.getHoraFim() < horafim || a.getHoraIni() >= horaInicio)) {
					choque += "Choque com - " + a.toString();
					horario.getSegunda().put(idTurma,new Alocacao(Util.factoryDao.getTurmaDao().getTurmas().get(idTurma), diaDaSemana,horaInicio, horafim));
				}
			}
		} else {
			throw new ExceptionParametroInvalido();
		}
		Util.bd.salvar();
		return choque;
	}

	
	/**
	 * metodo que desaloca uma turma em um determinado horario em um dia da semana.
	 * metodo tambem verifica se existe um choque de horario, para isso
	 * verica-se o dia em que o usuario deseja alocar a turma e o intervalo de
	 * tempo, antes de fazer o processo e recuperado do banco de dados os dados que estavam salvos
	 * e apos fazer o processo e salvado de novo 
	 * 
	 * @param idTurma
	 *            - identificador da turma
	 * @param diaDaSemana
	 *            - o dia da semana
	 * @param horaInicio
	 *            - a hora de inicio da aula
	 * @param horafim
	 *            - a hora do fim da aula
	 * @return - o choque de horario se houver
	 * @throws Exception
	 *             - parametros invalidos
	 */
	public String desalocaTurmaDoHorario(String idTurma, String diaDaSemana,
			int horaInicio, int horaFim) throws Exception {
		verificadorDeAtributos(idTurma, diaDaSemana, horaInicio, horaFim);
		horario.caregarHorario();
		String choque = "";

		if (diaDaSemana.equals("segunda")) {
			for (Alocacao a : horario.getSegunda().values()) {
				if ((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
						|| (a.getHoraFim() < horaFim || a.getHoraIni() >= horaInicio)) {
					horario.getSegunda().remove(idTurma);
					return "Ok";
				}
			}
		} else if (diaDaSemana.equals("terca")) {
			for (Alocacao a : horario.getTerca().values()) {
				if ((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
						|| (a.getHoraFim() < horaFim || a.getHoraIni() >= horaInicio)) {
					horario.getTerca().remove(idTurma);
					return "ok";
				}
			}
		} else if (diaDaSemana.equals("quarta")) {
			for (Alocacao a : horario.getQuarta().values()) {
				if ((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
						|| (a.getHoraFim() < horaFim || a.getHoraIni() >= horaInicio)) {
					horario.getQuarta().remove(idTurma);
					return "ok";
				}
			}
		} else if (diaDaSemana.equals("quinta")) {
			for (Alocacao a : horario.getQuinta().values()) {
				if ((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
						|| (a.getHoraFim() < horaFim || a.getHoraIni() >= horaInicio)) {
					horario.getQuinta().remove(idTurma);
					return "ok";
				}
			}
		} else if (diaDaSemana.equals("sexta")) {
			for (Alocacao a : horario.getSexta().values()) {
				if ((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
						|| (a.getHoraFim() < horaFim || a.getHoraIni() >= horaInicio)) {
					horario.getSexta().remove(idTurma);
					return "ok";
				}
			}
		} else {
			throw new ExceptionParametroInvalido();
		}
		Util.bd.salvar();
		return choque;
	}

	public String getHorario(String idTurma) throws H2Exception {
		Util.verificaAtributo(idTurma);
		horario.caregarHorario();
		String horarioTurma = "";
		if (verificador.comtemTurma(idTurma)) {
			
			if(horario.getSegunda().containsKey(idTurma)){
				horarioTurma += horario.getSegunda().get(idTurma).toString();
			}
			
			if(horario.getTerca().containsKey(idTurma)){
				horarioTurma += horario.getTerca().get(idTurma).toString();
			}
			
			if(horario.getQuarta().containsKey(idTurma)){
				horarioTurma += horario.getQuarta().get(idTurma).toString();
			}
			
			if(horario.getQuinta().containsKey(idTurma)){
				horarioTurma += horario.getQuinta().get(idTurma).toString();
			}
			
			if(horario.getSexta().containsKey(idTurma)){
				horarioTurma += horario.getSexta().get(idTurma).toString();
			}
			
		}else{
			throw new ExceptionTurmaNaoCadastrada();
		}
			
		return horarioTurma;
	}

	public String getTurmas(String diaDaSemana, int horaInicio, int horaFim)
			throws H2Exception {
		Util.verificaAtributo(diaDaSemana);
		horario.caregarHorario();
		if (diaDaSemana.equals("segunda")) {
			for (Alocacao a : horario.getSegunda().values()) {
				if (a.getHoraIni() == horaInicio && a.getHoraFim() == horaFim) {
					return a.getTurma().getId();
				}
			}
		} else if (diaDaSemana.equals("terca")) {
			for (Alocacao a : horario.getTerca().values()) {
				if (a.getHoraIni() == horaInicio && a.getHoraFim() == horaFim) {
					return a.getTurma().getId();
				}
			}
		} else if (diaDaSemana.equals("quarta")) {
			for (Alocacao a : horario.getQuarta().values()) {
				if (a.getHoraIni() == horaInicio && a.getHoraFim() == horaFim) {
					return a.getTurma().getId();
				}
			}
			
		} else if (diaDaSemana.equals("quinta")) {
			for (Alocacao a : horario.getQuinta().values()) {
				if (a.getHoraIni() == horaInicio && a.getHoraFim() == horaFim) {
					return a.getTurma().getId();
				}
			}
		} else if (diaDaSemana.equals("sexta")) {
			for (Alocacao a : horario.getSexta().values()) {
				if (a.getHoraIni() == horaInicio && a.getHoraFim() == horaFim) {
					return a.getTurma().getId();
				}
			}
		} else {
			throw new ExceptionParametroInvalido();
		}
		return null;
	}

	private void verificadorDeAtributos(String idTurma, String diaDaSemana,
			int horaInicio, int horafim) throws H2Exception {
		Util.verificaAtributo(idTurma, diaDaSemana);
		Util.verificaAtributoCargaHoraria(horaInicio, horafim);
		if (verificador.comtemTurma(idTurma)) {

		} else {
			throw new ExceptionParametroInvalido();
		}
	}
}
