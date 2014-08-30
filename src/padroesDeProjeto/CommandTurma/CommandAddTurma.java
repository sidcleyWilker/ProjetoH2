package padroesDeProjeto.CommandTurma;

import padroesDeProjeto.modelo.Turma;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

public class CommandAddTurma implements Command{

	private Turma turma;
	
	public CommandAddTurma() {
		// TODO Auto-generated constructor stub
	}

	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	@Override
	public void execut() {
		Util.fachadaDao.addTurma(turma);
		
	}

}
