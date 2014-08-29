package padoresDeProjeto.CommandSala;

import padroesDeProjeto.modelo.Sala;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

public class CommandAlteraSala implements Command{

	private Sala sala;
	private String novoBloco;

	public CommandAlteraSala() {
		// TODO Auto-generated constructor stub
	}


	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public void setNovoBloco(String novoBloco) {
		this.novoBloco = novoBloco;
	}

	/**
	 * delega a fachadaDao a responsabilidade de alterar o atributo bloco para o novo bloco
	 */
	@Override
	public void execut() {
		Util.fachadaDao.alteraSala(sala.getId(), novoBloco);
		
	}

}
