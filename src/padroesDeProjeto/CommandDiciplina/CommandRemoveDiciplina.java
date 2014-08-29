package padroesDeProjeto.CommandDiciplina;

import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;


public class CommandRemoveDiciplina implements Command{

	
	private Diciplina diciplina;
	
	public CommandRemoveDiciplina() {
		// TODO Auto-generated constructor stub
	}
	
	

	public void setDiciplina(Diciplina diciplina) {
		this.diciplina = diciplina;
	}



	@Override
	public void execut() {
		Util.fachadaDao.removeDisciplina(diciplina.getId());
		
	}

}
