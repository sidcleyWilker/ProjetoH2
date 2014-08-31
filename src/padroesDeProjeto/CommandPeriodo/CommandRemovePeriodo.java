package padroesDeProjeto.CommandPeriodo;

import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;
/**
 * class que executa o metodo de remover um periodo do sistema
 * @author Sidcley
 *
 */
public class CommandRemovePeriodo implements Command{

	private Periodo periodo;
	
	public CommandRemovePeriodo() {
		// TODO Auto-generated constructor stub
	}

	
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	/**
	 * delega a class fachadaDao a respomsabilidade de remover um periodo do sistema a parti do seu id
	 */
	@Override
	public void execut() {
		Util.fachadaDao.removePeriodo(periodo.getId());
		
	}

}
