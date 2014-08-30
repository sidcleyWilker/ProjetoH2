package padroesDeProjeto.CommandTurma;

import padroesDeProjeto.modelo.Turma;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

public class CommandRemoveTurma implements Command{

	private Turma turma;
	
	public CommandRemoveTurma() {
		// TODO Auto-generated constructor stub
	}

	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	@Override
	public void execut() {
		Util.fachadaDao.removerTurma(turma.getId());
		
	}

}
