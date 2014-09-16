package padroesDeProjeto.Alocacao;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.Exception.ExceptionTurmaNaoAlocada;
import padroesDeProjeto.Exception.ExceptionTurmaNaoCadastrada;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.modelo.Turma;
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
	private ArrayList<Alocacao> segunda = new ArrayList<>();
	private ArrayList<Alocacao> terca = new ArrayList<>();
	private ArrayList<Alocacao> quarta = new ArrayList<>();
	private ArrayList<Alocacao> quinta = new ArrayList<>();
	private ArrayList<Alocacao> sexta = new ArrayList<>();

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
		organizaHorario();
		String chock = "ok: ";
		
		if(diaDaSemana.equals("segunda")){
			chock +=verificaChoque(segunda, idTurma, diaDaSemana, horaInicio, horafim);
			
		}else if(diaDaSemana.equals("terca")){
			chock +=verificaChoque(terca, idTurma, diaDaSemana, horaInicio, horafim);
			
		}else if(diaDaSemana.equals("quarta")){
			chock +=verificaChoque(quarta, idTurma, diaDaSemana, horaInicio, horafim);
			
		}else if(diaDaSemana.equals("quinta")){
			chock +=verificaChoque(quinta, idTurma, diaDaSemana, horaInicio, horafim);
			
		}else if(diaDaSemana.equals("sexta")){
			chock +=verificaChoque(sexta, idTurma, diaDaSemana, horaInicio, horafim);
		}
	
		Util.factoryDao.getAlocacaoDao().criarAlocacao(idTurma+diaDaSemana+horaInicio+horafim,Util.factoryObject.criarAlocacao(idTurma, diaDaSemana, horaInicio, horafim));
		
		return chock;
	}

	
	/**
	 * metodo que desaloca uma turma em um determinado horario em um dia da semana.
	 * metodo verifica a existencia de uma turma alocada com esse parametros para
	 * poder remover, caso algum parametro estera errado vai ser lançada um 
	 * ExceptionTurmaNaoAlocada
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
	 *             - parametros invalidos ou ExceptionTurmaNaoAlocada
	 */
	public String desalocaTurmaDoHorario(String idTurma, String diaDaSemana,int horaInicio, int horafim) throws H2Exception {
		
		verificadorDeAtributos(idTurma, diaDaSemana, horaInicio, horafim);
		Map<String,Alocacao> horarios = Util.factoryDao.getAlocacaoDao().getAlocacoes();
		String keyRemove = idTurma+diaDaSemana+horaInicio+horafim;
		
		if (horarios.containsKey(keyRemove)){
			Util.factoryDao.getAlocacaoDao().removeAlocacao(keyRemove);
		}else{
			throw new ExceptionTurmaNaoAlocada();
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
	
	/**
	 * organiza os horarios salvos por dia 
	 */
	private void organizaHorario(){
		Map<String,Alocacao> horarios = Util.factoryDao.getAlocacaoDao().getAlocacoes();
		Set<String> keys =  horarios.keySet();
		for (String key : keys){
			if(horarios.get(key).getDiaSemana().equals("segunda")){
				segunda.add(horarios.get(key));
			}else if(horarios.get(key).getDiaSemana().equals("terca")){
				terca.add(horarios.get(key));
			}else if(horarios.get(key).getDiaSemana().equals("quarta")){
				quarta.add(horarios.get(key));
			}else if(horarios.get(key).getDiaSemana().equals("quinta")){
				quinta.add(horarios.get(key));
			}else if(horarios.get(key).getDiaSemana().equals("sexta")){
				sexta.add(horarios.get(key));
			}
		}
	}
	
	/**
	 * verifica se esta dando chock de horario quando vai cadastra outra turma
	 * para isso passa-se um array com os horarios cadastrados no dia que se 
	 * deseja cadastra um novo horario
	 * @param turmasDoDia - o arrey de turmas cadastradas em um dia da semana
	 * @param idTurma - o identificador da turma
	 * @param diaDaSemana - o dia da semana que se deseja cadastra a turma
	 * @param horaInicio - hora de inicio da aula
	 * @param horafim - hora do fim da aula
	 * @return - String vazia ou comtendo a msg de chock
	 */
	private String verificaChoque(ArrayList<Alocacao> turmasDoDia,String idTurma
			,String diaDaSemana,int horaInicio, int horafim){
		String chock = "";
		// pegar a turma no sistema para fazer as comparações
		Turma turmaACastratra = Util.factoryDao.getTurmaDao().getTurmas().get(idTurma);
		// a variavel "a" é uma turma já cadastrada
		for (Alocacao a : turmasDoDia){
			// verifica se a sala da turma esta ocupada
			if(a.getTurma().getSala().equals(turmaACastratra.getSala())){
				// verifica se a hora passada esta entre o intervalo da horada truma já cadastrada
				if((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
						|| (a.getHoraFim() < horafim || a.getHoraIni() >= horaInicio)){
					return chock+" Chock de sala com horario coma Turma: "+a.toString();
				}
			}
			/* verifica se os profesores são iguais 
			 * e se o profesor já esta dando aula em outro horario
			 */
			if(a.getTurma().getProfessor().equals(turmaACastratra.getProfessor())){
				if((horaInicio >= a.getHoraIni() || horaInicio < a.getHoraFim())
						|| (a.getHoraFim() < horafim || a.getHoraIni() >= horaInicio)){
					return chock+" Chock professor esta dando aula na truma: "+a.toString();
				}
			}
			
		}		
		
		return chock;
	}
}
