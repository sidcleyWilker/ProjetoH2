package padroesDeProjeto.CommandPeriodo;

import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

public class CommandAddPeriodo implements Command{

	private Periodo periodo;
	
	public CommandAddPeriodo() {
		// TODO Auto-generated constructor stub
	}

	
	public void setPerioodo(Periodo periodo) {
		this.periodo = periodo;
	}


	@Override
	public void execut() {
		Util.fachadaDao.addPeriodo(periodo);
		
	}

}
