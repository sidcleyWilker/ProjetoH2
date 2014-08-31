package padroesDeProjeto.CommandDiciplina;

import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

/**
 * class que executa o commando de remover uma diciplina do sistema
 * @author Sidcley
 *
 */
public class CommandRemoveDiciplina implements Command{

	
	private Diciplina diciplina;
	
	public CommandRemoveDiciplina() {
		// TODO Auto-generated constructor stub
	}
	
	

	public void setDiciplina(Diciplina diciplina) {
		this.diciplina = diciplina;
	}


	/**
	 * delega a class fachadaDao a responsabilidade de remover uma diciplina atravez do seu id
	 */
	@Override
	public void execut() {
		Util.fachadaDao.removeDisciplina(diciplina.getId());
		
	}

}
