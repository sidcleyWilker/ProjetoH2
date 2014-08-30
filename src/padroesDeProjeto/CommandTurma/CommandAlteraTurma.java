package padroesDeProjeto.CommandTurma;

import padroesDeProjeto.modelo.Turma;
import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

public class CommandAlteraTurma implements Command{

	private Turma turma;
	private String campo;
	private Object novoValor;
	
	public CommandAlteraTurma() {
		// TODO Auto-generated constructor stub
	}

	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	

	public void setCampo(String campo) {
		this.campo = campo;
	}


	public void setNovoValor(Object novoValor) {
		this.novoValor = novoValor;
	}


	@Override
	public void execut() {
		Util.fachadaDao.alteraTurma(turma.getId(), campo, novoValor);
		
	}

}
