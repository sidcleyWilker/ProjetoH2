package padroesDeProjeto.CommandProfessor;

import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;
/**
 * class que executa o comando de alterar o atributo de um professor no sistema
 * @author Sidcley
 *
 */
public class CommandAlteraProfessor implements Command{

	private Professor professor;
	private String novoNome;
	
	public CommandAlteraProfessor() {

	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public void setNovoNome(String novoNome){
		this.novoNome = novoNome;
	}

	/**
	 * delega a class fachadaDao a responsabilidade de alterar o atributo nome de um professor
	 */
	@Override
	public void execut() {
		Util.fachadaDao.alteraProfessor(professor.getId(), novoNome);
		
	}

}
