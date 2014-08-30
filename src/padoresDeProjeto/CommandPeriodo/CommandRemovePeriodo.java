package padoresDeProjeto.CommandPeriodo;

import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

public class CommandRemovePeriodo implements Command{

	private Periodo periodo;
	
	public CommandRemovePeriodo() {
		// TODO Auto-generated constructor stub
	}

	
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}


	@Override
	public void execut() {
		Util.fachadaDao.removePeriodo(periodo.getId());
		
	}

}
