package padroesDeProjeto.CommandCurso;

import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;
/**
 * class que executa o commando de adicionar um curso no sistema
 * @author Sidcley
 *
 */
public class CommandAddCurso implements Command {

	private Curso curso;

	public CommandAddCurso() {
		// TODO Auto-generated constructor stub
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	/**
	 * delega a class fachadaDao a responsabilidade de adicionar um curso ao sistema
	 */
	@Override
	public void execut() {
		Util.fachadaDao.addCurso(curso);
		
	}

}
