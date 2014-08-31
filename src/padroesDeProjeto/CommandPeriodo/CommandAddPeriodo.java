package padroesDeProjeto.CommandPeriodo;

import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

/**
 * class que executa o comando de adicionar um periodo ou sistema
 * @author Sidcley
 *
 */
public class CommandAddPeriodo implements Command{

	private Periodo periodo;
	
	public CommandAddPeriodo() {
		// TODO Auto-generated constructor stub
	}

	
	public void setPerioodo(Periodo periodo) {
		this.periodo = periodo;
	}

	/**
	 * delega a class fachadaDao a responsabilidade de adicionar um periodo ao sistema
	 */
	@Override
	public void execut() {
		Util.fachadaDao.addPeriodo(periodo);
		
	}

}
