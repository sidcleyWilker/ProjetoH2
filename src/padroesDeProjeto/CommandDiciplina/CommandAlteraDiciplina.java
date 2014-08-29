package padroesDeProjeto.CommandDiciplina;

import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;


public class CommandAlteraDiciplina implements Command{

	private String keyDiciplina;
	private String atributo;
	private String novoValor;

	public CommandAlteraDiciplina() {
		
	}


	public void setKeyDiciplina(String keyDiciplina) {
		this.keyDiciplina = keyDiciplina;
	}



	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}



	public void setNovoValor(String novoValor) {
		this.novoValor = novoValor;
	}



	@Override
	public void execut(){
		Util.fachadaDao.alteraDisciplina(keyDiciplina, atributo, novoValor);
		
	}

}
