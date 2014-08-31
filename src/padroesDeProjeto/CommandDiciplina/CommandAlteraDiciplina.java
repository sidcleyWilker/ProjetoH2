package padroesDeProjeto.CommandDiciplina;

import padroesDeProjeto.util.Command;
import padroesDeProjeto.util.Util;

/**
 * class que executa a responsabilidade de alterar o valor do atributo de uma diciplina
 * @author Sidcley
 *
 */
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


	/**
	 * delega a class fachadaDao a responsabilidade de fazer a alteração parando a chave da diciplina,
	 * o atributo e o novo valor
	 */
	@Override
	public void execut(){
		Util.fachadaDao.alteraDisciplina(keyDiciplina, atributo, novoValor);
		
	}

}
