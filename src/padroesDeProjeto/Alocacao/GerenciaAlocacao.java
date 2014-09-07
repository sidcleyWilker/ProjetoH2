package padroesDeProjeto.Alocacao;

import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.Exception.ExceptionTurmaNaoCadastrada;
import padroesDeProjeto.Exception.ExceptionTurmaSemHorario;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.factory.FactoryDAO;
import padroesDeProjeto.util.Util;
import padroesDeProjeto.util.VerificadorDeObjetos;

/**
 * class vai gerencia o funcionamento da aloca��o da desaloca��o de obter o
 * horario de uma turma e as turmas de uma semana
 * 
 * @author Sidcley
 * 
 */
public class GerenciaAlocacao {

	private VerificadorDeObjetos verificador;

	public GerenciaAlocacao() {
		verificador = new VerificadorDeObjetos();
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
	public String alocaTurmaAoHorario(String idTurma, String diaDaSemana,int horaInicio, int horafim) throws H2Exception {
		
		verificadorDeAtributos(idTurma, diaDaSemana, horaInicio, horafim);

		String choque = "ok";
		
		if(Util.factoryDao.getAlocacaoDao().getAlocacoes().size() > 0){
		
			for(Alocacao a : Util.factoryDao.getAlocacaoDao().getAlocacoes().values()){
				if(a.getDiaSemana().equals(diaDaSemana)){
					if ((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim()) || (a.getHoraFim() < horafim || a.getHoraIni() >= horaInicio)){
						choque += " Choque na segunda com - " + a.toString();
						Util.factoryDao.getAlocacaoDao().criarAlocacao(Util.factoryObject.criarAlocacao(idTurma, diaDaSemana, horaInicio, horafim));
					}else{
						Util.factoryDao.getAlocacaoDao().criarAlocacao(Util.factoryObject.criarAlocacao(idTurma, diaDaSemana, horaInicio, horafim));
					}
				}else{
					Util.factoryDao.getAlocacaoDao().criarAlocacao(Util.factoryObject.criarAlocacao(idTurma, diaDaSemana, horaInicio, horafim));
				}
			}
		}else{
		
			Util.factoryDao.getAlocacaoDao().criarAlocacao(Util.factoryObject.criarAlocacao(idTurma, diaDaSemana, horaInicio, horafim));
		}
		
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
			int horaInicio, int horaFim) throws H2Exception {
		verificadorDeAtributos(idTurma, diaDaSemana, horaInicio, horaFim);
//		horario.caregarHorario();
//		String choque = "";
//
//		if (diaDaSemana.equals("segunda")) {
//			for (Alocacao a : horario.getSegunda().values()) {
//				if ((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
//						|| (a.getHoraFim() < horaFim || a.getHoraIni() >= horaInicio)) {
//					horario.getSegunda().remove(idTurma);
//					return "Ok";
//				}
//			}
//		} else if (diaDaSemana.equals("terca")) {
//			for (Alocacao a : horario.getTerca().values()) {
//				if ((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
//						|| (a.getHoraFim() < horaFim || a.getHoraIni() >= horaInicio)) {
//					horario.getTerca().remove(idTurma);
//					return "ok";
//				}
//			}
//		} else if (diaDaSemana.equals("quarta")) {
//			for (Alocacao a : horario.getQuarta().values()) {
//				if ((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
//						|| (a.getHoraFim() < horaFim || a.getHoraIni() >= horaInicio)) {
//					horario.getQuarta().remove(idTurma);
//					return "ok";
//				}
//			}
//		} else if (diaDaSemana.equals("quinta")) {
//			for (Alocacao a : horario.getQuinta().values()) {
//				if ((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
//						|| (a.getHoraFim() < horaFim || a.getHoraIni() >= horaInicio)) {
//					horario.getQuinta().remove(idTurma);
//					return "ok";
//				}
//			}
//		} else if (diaDaSemana.equals("sexta")) {
//			for (Alocacao a : horario.getSexta().values()) {
//				if ((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
//						|| (a.getHoraFim() < horaFim || a.getHoraIni() >= horaInicio)) {
//					horario.getSexta().remove(idTurma);
//					return "ok";
//				}
//			}
//		} else {
//			throw new ExceptionParametroInvalido();
//		}
//		Util.bd.salvar();
		return null;
	}

	/**
	 * M�todo que apresenta o hor�rio da turma em formato String. Caso a turma
	 * n�o esteja alocada em nenhum hor�rio, vai ser lan�ada uma exce��o com a
	 * mensagem "Turma sem hor�rio". O hor�rio segui o seguinte formato:
	 * 
	 * Segunda: 10 �s 12 Ter�a: 14 �s 16 Sexta: 8 �s 10
	 * 
	 * Lembrando que n�o a op��o de hora fracionada.
	 * 
	 * @param idTurma
	 *            O c�digo que identifica a turma
	 * @return O hor�rio da turma
	 * @throws H2Exception
	 *             Caso a turma n�o tenha sido alocada ainda. Ou caso algum dos par�metros seja inv�lido.
	 */
	public String getHorario(String idTurma) throws H2Exception {
		Util.verificaAtributo(idTurma);
//		horario.caregarHorario();
//		boolean cadastrado = false;
//		String horarioTurma = "";
//		if (verificador.comtemTurma(idTurma)) {
//			
//			if(horario.getSegunda().containsKey(idTurma)){
//				horarioTurma += horario.getSegunda().get(idTurma).toString();
//				cadastrado = true;
//			}
//			if(horario.getTerca().containsKey(idTurma)){
//				horarioTurma += horario.getTerca().get(idTurma).toString();
//				cadastrado = true;
//			}
//			if(horario.getQuarta().containsKey(idTurma)){
//				horarioTurma += horario.getQuarta().get(idTurma).toString();
//				cadastrado = true;
//			}
//			if(horario.getQuinta().containsKey(idTurma)){
//				horarioTurma += horario.getQuinta().get(idTurma).toString();
//				cadastrado = true;
//			}
//			if(horario.getSexta().containsKey(idTurma)){
//				horarioTurma += horario.getSexta().get(idTurma).toString();
//				cadastrado = true;
//			}
//			
//		}else{
//			throw new ExceptionTurmaNaoCadastrada();
//		}
//		if(cadastrado == false){
//			throw new ExceptionTurmaSemHorario();
//		}else{
			return null;
		}
		
	

	/**
	 * apresenta as turmas que foram alocadas no hor�rio passado como
	 * par�metro.
	 * @param diaDaSemana - dia da semana
	 * @param horaInicio - hora de inicio da aula
	 * @param horaFim - hora do fim da aula
	 * @return - o id da turka
	 * @throws H2Exception
	 */
	public String getTurmas(String diaDaSemana, int horaInicio, int horaFim)
			throws H2Exception {
		Util.verificaAtributo(diaDaSemana);
//		horario.caregarHorario();
//		if (diaDaSemana.equals("segunda")) {
//			for (Alocacao a : horario.getSegunda().values()) {
//				if (a.getHoraIni() == horaInicio && a.getHoraFim() == horaFim) {
//					return a.getTurma().getId();
//				}
//			}
//		} else if (diaDaSemana.equals("terca")) {
//			for (Alocacao a : horario.getTerca().values()) {
//				if (a.getHoraIni() == horaInicio && a.getHoraFim() == horaFim) {
//					return a.getTurma().getId();
//				}
//			}
//		} else if (diaDaSemana.equals("quarta")) {
//			for (Alocacao a : horario.getQuarta().values()) {
//				if (a.getHoraIni() == horaInicio && a.getHoraFim() == horaFim) {
//					return a.getTurma().getId();
//				}
//			}
//			
//		} else if (diaDaSemana.equals("quinta")) {
//			for (Alocacao a : horario.getQuinta().values()) {
//				if (a.getHoraIni() == horaInicio && a.getHoraFim() == horaFim) {
//					return a.getTurma().getId();
//				}
//			}
//		} else if (diaDaSemana.equals("sexta")) {
//			for (Alocacao a : horario.getSexta().values()) {
//				if (a.getHoraIni() == horaInicio && a.getHoraFim() == horaFim) {
//					return a.getTurma().getId();
//				}
//			}
//		} else {
//			throw new ExceptionParametroInvalido();
//		}
		return null;
	}

	/**
	 * verifica se todos os atributos foram passados coretamente e se a turma esta cadastrada no sistema
	 * @param idTurma
	 * @param diaDaSemana
	 * @param horaInicio
	 * @param horafim
	 * @throws H2Exception
	 */
	private void verificadorDeAtributos(String idTurma, String diaDaSemana,
			int horaInicio, int horafim) throws H2Exception {
		Util.verificaAtributo(idTurma, diaDaSemana);
		Util.verificaAtributoCargaHoraria(horaInicio, horafim);
		if(!verificador.comtemTurma(idTurma)){
			throw new ExceptionTurmaNaoCadastrada();
		}
	}
}
