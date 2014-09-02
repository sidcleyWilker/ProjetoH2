package padroesDeProjeto.Proxy;

import padroesDeProjeto.CommandSala.CommandAddSala;
import padroesDeProjeto.CommandSala.CommandAlteraSala;
import padroesDeProjeto.CommandSala.CommandRemoveSala;
import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.Exception.ExceptionSalaJaCadastrada;
import padroesDeProjeto.Exception.ExceptionSalaNaoCadastrada;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.util.Comtroler;
import padroesDeProjeto.util.Util;
import padroesDeProjeto.util.VerificadorDeObjetos;

public class ProxySala {
	
	private CommandAddSala commandAddSala;
	private CommandAlteraSala commandAlteraSala;
	private CommandRemoveSala commandRemoveSala;
	private Comtroler controler;
	private VerificadorDeObjetos verificador;
	
	
	public ProxySala() {
		this.commandAddSala = new CommandAddSala();
		this.commandAlteraSala = new CommandAlteraSala();
		this.commandRemoveSala = new CommandRemoveSala();
		this.controler = new Comtroler();
		this.verificador  = new VerificadorDeObjetos();
	}

	/**
	 * verifica se os atributos são vazios ou nullos, verifica-se se já contem uma sala cadastrada
	 * com esse id, altera-se a sala da class commanAddSala, passando uma nova sala, altera-se o 
	 * commando da class controle e pede para executar o commando
	 * @param idSala - identificador da sala
	 * @param bloco - bloco onde a sala se encontra 
	 * @throws H2Exception - sala j´´a cadastrada e parametros iinvalidos
	 */
	public void add(String idSala, String bloco) throws H2Exception{
		Util.verificaAtributo(idSala,bloco);
		if(!(verificador.comtemSala(idSala))){
			commandAddSala.setSala(Util.factoryObject.criarSala(idSala, bloco));
			controler.setCommand(commandAddSala);
			controler.executarCommando();
		}else{
			throw new ExceptionSalaJaCadastrada();
		}
	}
	
	/**
	 * verifica se os atributo passados são vazios ou nullos,verifica-se se existe uma sala 
	 * cadastrada no sistema com esse id, altera-se a sala da class commandAlteraSala passando 
	 * a sala com o id passado, altera-se o atributo novo bloco passando o bloco passado como parametro,
	 * altera-se o commando da class controle e pede a ele executar o metodo execute
	 * @param idSala - identificadr da sala
	 * @param novoBloco - o novo bloco para a ssala
	 * @throws H2Exception - sala já cadastrada && prametros invalidos
	 */
	public void altera(String idSala, String novoBloco) throws H2Exception{
		Util.verificaAtributo(idSala,novoBloco);
		if(verificador.comtemSala(idSala)){
			commandAlteraSala.setSala(Util.factoryDao.getSalaDao().getSalas().get(idSala));
			commandAlteraSala.setNovoBloco(novoBloco);
			controler.setCommand(commandAlteraSala);
			controler.executarCommando();
		}else{
			throw new ExceptionSalaNaoCadastrada();
		}
	}
	
	/**
	 * remove uma sala aparte do seu identificador, verifica se o id pasado é vazio ou nullo e verifica
	 * se a sala esta cadastrada no sistema
	 * @param id - identificador da sala
	 * @throws H2Exception - sala não cadastrada e parametros invalidos
	 */
	public void remove(String id) throws H2Exception{
		Util.verificaAtributo(id);
		if(verificador.comtemSala(id)){
			commandRemoveSala.setSala(Util.factoryDao.getSalaDao().getSalas().get(id));
			controler.setCommand(commandRemoveSala);
			controler.executarCommando();
		}else{
			throw new ExceptionSalaNaoCadastrada();
		}
	}
	
	/**
	 * verifica se o id é vazio ou nullo, verifica se a sala esta cadastrada no
	 * sistema.
	 * @param id - identificador da sala
	 * @return - retorna o toString apartido id
	 * @throws H2Exception - parametros invalidos ou sala não cadastrada
	 */
	public String getSala(String id) throws H2Exception{
		Util.verificaAtributo(id);
		if (verificador.comtemSala(id)){
			return Util.fachadaDao.getSala(id);
		}else{
			throw new ExceptionSalaNaoCadastrada();
		}
	}
}
