package padoresDeProjeto.CommandSala;

import padroesDeProjeto.modelo.Sala;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

/**
 * class que executa o command de excluir uma sala do sistema
 *@author Sidcley
 *
 */
public class CommandRemoveSala implements Command{

	private Sala sala;
	
	public CommandRemoveSala() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setSala(Sala sala) {
		this.sala = sala;
	}


	/**
	 * delega a class fachadaDao a responsabilidade de remover uma sala com esse id
	 */
	@Override
	public void execut() {
		Util.fachadaDao.removeSala(sala.getId());
		
	}

}
