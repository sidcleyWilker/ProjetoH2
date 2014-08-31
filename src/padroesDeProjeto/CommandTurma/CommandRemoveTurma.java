package padroesDeProjeto.CommandTurma;

import padroesDeProjeto.modelo.Turma;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;
/**
 * class que executa o commando de remover uma turma do sistema
 * @author Sidcley
 *
 */
public class CommandRemoveTurma implements Command{

	private Turma turma;
	
	public CommandRemoveTurma() {
		// TODO Auto-generated constructor stub
	}

	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	/**
	 * delega a class fachadaDao a responsabilidade de remover uma turma do sistema aparti do seu id
	 */
	@Override
	public void execut() {
		Util.fachadaDao.removerTurma(turma.getId());
		
	}

}
