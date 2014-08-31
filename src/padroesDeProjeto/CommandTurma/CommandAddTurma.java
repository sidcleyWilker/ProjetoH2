package padroesDeProjeto.CommandTurma;

import padroesDeProjeto.modelo.Turma;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;
/**
 * class que executa o commando de adicionar uma turma ao sistema
 * @author Sidcley
 *
 */
public class CommandAddTurma implements Command{

	private Turma turma;
	
	public CommandAddTurma() {
		// TODO Auto-generated constructor stub
	}

	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	/**
	 * delega a class fachadaDao a responsabilidade de adicinar uma turma ao sistema
	 */
	@Override
	public void execut() {
		Util.fachadaDao.addTurma(turma);
		
	}

}
