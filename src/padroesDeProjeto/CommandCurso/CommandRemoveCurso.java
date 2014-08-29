package padroesDeProjeto.CommandCurso;

import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;
/**
 * class que executa o commando de remover um curso a parti do seu identificador
 * @author Sidcley
 *
 */
public class CommandRemoveCurso implements Command{

	private Curso curso;
	
	public CommandRemoveCurso() {
		// TODO Auto-generated constructor stub
	}

	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * delega a class fachadaDao a responsabilidade de remover um curso aparti do seu id
	 */
	@Override
	public void execut(){
		Util.fachadaDao.removeCurso(curso.getId());
		
	}

}
