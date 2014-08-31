package padroesDeProjeto.CommandDiciplina;

import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

/**
 * class que executa o commando de adicionar uma diciplina ao sistema
 * @author Sidcley
 *
 */
public class CommandAddDiciplina implements Command{

	private Diciplina diciplina;
	
	
	public CommandAddDiciplina() {
		// TODO Auto-generated constructor stub
	}

	
	public void setDicipina(Diciplina diciplina) {
		this.diciplina = diciplina;
	}

	/**
	 * delega a fachadaDao a responsabilidade de adicionar uma diciplina ao sistema
	 */
	@Override
	public void execut() {
		Util.fachadaDao.addDisciplinaAoPeriodo(diciplina);
		
	}

}
