package padroesDeProjeto.CommandProfessor;

import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

/**
 * class que executa o comando para que seja adicionado um professor no sistema
 * @author Sidcley
 *
 */
public class CommandAddProfessor implements Command {

	private Professor professor;
	
	public CommandAddProfessor() {

	}
	

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	/**
	 * delega a class fachadaDao a função de adicionar um professor no sistema
	 */
	@Override
	public void execut() {
		Util.fachadaDao.addProfessor(professor);
		
	}

}
