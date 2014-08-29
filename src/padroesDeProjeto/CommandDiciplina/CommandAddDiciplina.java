package padroesDeProjeto.CommandDiciplina;

import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;


public class CommandAddDiciplina implements Command{

	private Diciplina diciplina;
	
	
	public CommandAddDiciplina() {
		// TODO Auto-generated constructor stub
	}

	
	public void setDicipina(Diciplina diciplina) {
		this.diciplina = diciplina;
	}


	@Override
	public void execut() {
		Util.fachadaDao.addDisciplinaAoPeriodo(diciplina);
		
	}

}
