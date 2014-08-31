package padroesDeProjeto.Proxy;

import padroesDeProjeto.CommandProfessor.CommandAddProfessor;
import padroesDeProjeto.CommandProfessor.CommandAlteraProfessor;
import padroesDeProjeto.CommandProfessor.CommandRemoveProfessor;
import padroesDeProjeto.Exception.ExceptionProfessorJaCadastrado;
import padroesDeProjeto.Exception.ExceptionProfessorNaoCadastrado;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.util.Comtroler;
import padroesDeProjeto.util.Util;
import padroesDeProjeto.util.VerificadorDeObjetos;

public class ProxyProfessor {
	
	private CommandAddProfessor commandAddProfessor;
	private CommandAlteraProfessor commandAlteraProfessor;
	private CommandRemoveProfessor commandRemoveProfessor;
	private Comtroler controler;
	private VerificadorDeObjetos verificador;

	public ProxyProfessor() {
		this.commandAddProfessor = new CommandAddProfessor();
		this.commandAlteraProfessor = new CommandAlteraProfessor();
		this.commandRemoveProfessor = new CommandRemoveProfessor();
		this.controler = new Comtroler();
		this.verificador = new VerificadorDeObjetos();
	}
	/**
	 * verifica se os atributos foram pasados coretamentes e se o professor ainda não esta cadastrado no 
	 * sistema, caso esteja tudo ok, altera-se o professor da class commandAddProfessor 
	 * passando um novo professo, altera o commando da class comtrole e pede para a mesma executar o commando
	 * Add
	 * @param id - identificador do professor
	 * @param nome - nome do professor
	 * @throws H2Exception 
	 * 						parametros invalidos || professor já cadastrado
	 */
	public void add(String id, String nome) throws H2Exception{
		Util.verificaAtributo(id,nome);
		if(verificador.contemProfessor(id)){
			throw new ExceptionProfessorJaCadastrado("Professor Já Cadastrado");
		}else{
			commandAddProfessor.setProfessor((Professor)Util.factoryObject.objectTypeModelo("professor", id, nome));
			controler.setCommand(commandAddProfessor);
			controler.executarCommando();
		}
	}
	
	/**
	 * verifica os atributos pasados, verifica se existe um professor no sistema com o id.
	 * caso esteja tudo ok, pegamos o professor com o id pasado para a class commandAlteraProfessor
	 * e o novo nome, depois alteramos o comando da class controle e pedimos para que excute
	 * o commando de alterar 
	 * @param idProfessor - identificador do professor
	 * @param novoNome - novo nome do professor
	 * @throws H2Exception
	 * 					parametros invalidos || professor não cadastrado
	 */
	public void alterar(String idProfessor, String novoNome)throws H2Exception{
		Util.verificaAtributo(idProfessor,novoNome);
		if(verificador.contemProfessor(idProfessor)){
			commandAlteraProfessor.setProfessor(Util.bd.getProfessores().get(idProfessor));
			commandAlteraProfessor.setNovoNome(novoNome);
			controler.setCommand(commandAlteraProfessor);
			controler.executarCommando();
		}else{
			throw new ExceptionProfessorNaoCadastrado("Professor Não Cadastrado");
		}
	}
	
	/**
	 * verifica o atributo id, verifica se existe um prfessor cadastrado com esse id,
	 * caso esteja tudo ok. altera-se o professor da class commandRemoveProfessor para o 
	 * professor que tenha esse id, alterase o command da class controle e pede para executar esse
	 * command de remover 
	 * @param id - identificadr do professor
	 * @throws H2Exception
	 * 					parametros invalidos || professor não cadastrado
	 */
	public void remover(String id) throws H2Exception{
		Util.verificaAtributo(id);
		if(verificador.contemProfessor(id)){
			commandRemoveProfessor.setProfessor(Util.bd.getProfessores().get(id));
			controler.setCommand(commandRemoveProfessor);
			controler.executarCommando();
		}else{
			throw new ExceptionProfessorNaoCadastrado("Professor Não Cadastrado");
		}
	}
	
	/**
	 * retorna o toString de um professor que tenha esse id caso ele esteja cadastrado no sistema
	 * @param id
	 * @return
	 * @throws H2Exception 
	 * 						Professor Não Cadastrado - atributo invalido
	 */
	public String getToStringProfessor(String id) throws H2Exception{
		Util.verificaAtributo(id);
		if(verificador.contemProfessor(id)){
			return Util.bd.getProfessores().get(id).toString();
		}else{
			throw new ExceptionProfessorNaoCadastrado("Professor Não Cadastrado");
		}
	}
}
