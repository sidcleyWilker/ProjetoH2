package padroesDeProjeto.CommandSala;

import padroesDeProjeto.modelo.Sala;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

/**
 * class que executa o commando de adicionar uma sala no sitema
 * @author Sidcley
 *
 */
public class CommandAddSala implements Command {

	private Sala sala;
	
	public CommandAddSala() {
		// TODO Auto-generated constructor stub
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	/**
	 * delega a class fachadaDao a responsabilidade de adicionar uma sala no sistema
	 */
	@Override
	public void execut() {
		Util.fachadaDao.addSala(sala);
		
	}

}
