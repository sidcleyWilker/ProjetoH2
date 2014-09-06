package padroesDeProjeto.CommandTurma;

import padroesDeProjeto.modelo.Turma;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;
/**
 * class que executa o commando de alterar o valor de uma turma no sistema
 * @author Sidcley
 *
 */
public class CommandAlteraTurma implements Command{

	private Turma turma;
	private String campo;
	private String novoValor;
	
	public CommandAlteraTurma() {
		// TODO Auto-generated constructor stub
	}

	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	

	public void setCampo(String campo) {
		this.campo = campo;
	}


	public void setNovoValor(String novoValor) {
		this.novoValor = novoValor;
	}

	/**
	 * delega a class fachadaDao a responsabilidade de fazer a alteração passando a chave o campo 
	 * e o novoValor
	 */
	@Override
	public void execut() {
		Util.fachadaDao.alteraTurma(turma.getId(), campo, novoValor);
		
	}

}
