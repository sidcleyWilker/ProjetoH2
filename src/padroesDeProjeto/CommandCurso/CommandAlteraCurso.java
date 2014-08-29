package padroesDeProjeto.CommandCurso;

import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;
/**
 * class que executa o commando de altera o atributo de um curso
 * @author Sidcley
 *
 */
public class CommandAlteraCurso implements Command{

	private Curso curso;
	private String novoValor;
	
	public CommandAlteraCurso() {
		// TODO Auto-generated constructor stub
	}

	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	

	public void setNovoValor(String novoValor) {
		this.novoValor = novoValor;
	}

	/**
	 * delega a class fachadaDao a responsabilidade de alterar o valor de um curso
	 */
	@Override
	public void execut() {
		Util.fachadaDao.alterarCurso(curso.getId(), novoValor);
		
	}

}
