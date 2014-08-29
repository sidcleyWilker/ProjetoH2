package padroesDeProjeto.CommandProfessor;

import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;
/**
 * class que executa o commando de remover um professor
 * @author Sidcley
 *
 */
public class CommandRemoveProfessor implements Command{

	private Professor professor;
	
	public CommandRemoveProfessor() {
	
	}

	public void setProfessor(Professor professor){
		this.professor = professor;
	}

	/**
	 * delega a class a responsabilidade de removre um professor atraves do seu id 
	 */
	@Override
	public void execut() {
		Util.fachadaDao.removeProfessor(professor.getId());
		
	}
	
	
	
}
