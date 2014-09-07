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

	public GerenciaAlocacao() {
		verificador = new VerificadorDeObjetos();
	}

	/**
	 * metodo que aloca uma turma em um determinado horario em um dia da semana.
	 * metodo tambem verifica se existe um choque de horario, para isso
	 * verica-se o dia em que o usuario deseja alocar a turma e o intervalo de
	 * tempo.
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
						choque += " Choque com - " + a.toString();
						Util.factoryDao.getAlocacaoDao().criarAlocacao(idTurma+diaDaSemana+horaInicio+horafim,Util.factoryObject.criarAlocacao(idTurma, diaDaSemana, horaInicio, horafim));
					}else{
						Util.factoryDao.getAlocacaoDao().criarAlocacao(idTurma+diaDaSemana+horaInicio+horafim,Util.factoryObject.criarAlocacao(idTurma, diaDaSemana, horaInicio, horafim));
					}
				}else{
					Util.factoryDao.getAlocacaoDao().criarAlocacao(idTurma+diaDaSemana+horaInicio+horafim,Util.factoryObject.criarAlocacao(idTurma, diaDaSemana, horaInicio, horafim));
				}
			}
		}else{
		
			Util.factoryDao.getAlocacaoDao().criarAlocacao(idTurma+diaDaSemana+horaInicio+horafim,Util.factoryObject.criarAlocacao(idTurma, diaDaSemana, horaInicio, horafim));
		}
		
		return choque;
	}

	
	/**
	 * metodo que desaloca uma turma em um determinado horario em um dia da semana.
	 * metodo tambem verifica se existe um choque de horario, para isso
	 * verica-se o dia em que o usuario deseja alocar a turma e o intervalo de
	 * tempo
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
	public String desalocaTurmaDoHorario(String idTurma, String diaDaSemana,int horaInicio, int horafim) throws H2Exception {
		
		verificadorDeAtributos(idTurma, diaDaSemana, horaInicio, horafim);
		
		if(Util.factoryDao.getAlocacaoDao().getAlocacoes().size() > 0){
			
			for(Alocacao a : Util.factoryDao.getAlocacaoDao().getAlocacoes().values()){
				if((a.getTurma().getId()+a.getDiaSemana()+a.getHoraIni()+a.getHoraFim()).equals(idTurma+diaDaSemana+horaInicio+horafim)){
					Util.factoryDao.getAlocacaoDao().removeAlocacao(idTurma+diaDaSemana+horaInicio+horafim);
				}
			}
		}else{
			Util.factoryDao.getAlocacaoDao().removeAlocacao(idTurma+diaDaSemana+horaInicio+horafim);
		}
		
		return "ok";
		}
		
	

	/**
	 * apresenta as turmas que foram alocadas no horário passado como
	 * parâmetro.
	 * @param diaDaSemana - dia da semana
	 * @param horaInicio - hora de inicio da aula
	 * @param horaFim - hora do fim da aula
	 * @return - o id da turka
	 * @throws H2Exception
	 */
	public String getTurmas(String diaDaSemana, int horaInicio, int horaFim)throws H2Exception {
		Util.verificaAtributo(diaDaSemana);
		Util.verificaAtributoCargaHoraria(horaInicio , horaFim);
		String turmas = "";		
		for(Alocacao a : Util.factoryDao.getAlocacaoDao().getAlocacoes().values()){
			if(a.getDiaSemana().equals(diaDaSemana) && a.getHoraIni() == horaInicio && a.getHoraFim() == horaFim){
					turmas += a.toString()+" ";
			}
		}
		
		
		return turmas;
	}

	/**
	 * Método que apresenta o horário da turma em formato String. Caso a turma
	 * não esteja alocada em nenhum horário, deve ser lançada uma exceção com a
	 * mensagem "Turma sem horário"
	 * @param idTurma - identificador da turma
	 *@return - O horário da turma
	 *@throws H2Exception
	 *             Caso a turma não tenha sido alocada ainda. Ou caso algum dos parâmetros seja inválido.
	 */
	public String getHorario(String idTurma) throws H2Exception {
		Util.verificaAtributo(idTurma);
		String horario = "";
		boolean alocada = false;
		if(verificador.comtemTurma(idTurma)){
			for(Alocacao a : Util.factoryDao.getAlocacaoDao().getAlocacoes().values()){
				if(a.getTurma().getId().equals(idTurma)){
						alocada = true;
						horario += a.toString();
				}
			}
		}else{
			throw new ExceptionTurmaNaoCadastrada();
		}
		
		if(alocada){
			return horario;
		}else{
			throw new ExceptionTurmaNaoAlocada();
		}
		
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
		if(!diaDaSemana.equals("segunda") && !diaDaSemana.equals("terca") && !diaDaSemana.equals("quarta")
				&& !diaDaSemana.equals("quinta") && !diaDaSemana.equals("sexta")){
			throw new ExceptionParametroInvalido();
		}
		if(!verificador.comtemTurma(idTurma)){
			throw new ExceptionTurmaNaoCadastrada();
		}
	}
}
