package padroesDeProjeto.Proxy;

import padroesDeProjeto.CommandPeriodo.CommandAddPeriodo;
import padroesDeProjeto.CommandPeriodo.CommandRemovePeriodo;
import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.Exception.ExceptionPeriodoJaCadastrado;
import padroesDeProjeto.Exception.ExceptionPeriodoNaoCadastrado;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.util.Comtroler;
import padroesDeProjeto.util.Util;
import padroesDeProjeto.util.VerificadorDeObjetos;

public class ProxyPeriodo {

	private CommandAddPeriodo commandAddPeriodo;
	private CommandRemovePeriodo commandRemovePeriodo;
	private Comtroler controler;
	private VerificadorDeObjetos verificador;
	
	
	public ProxyPeriodo() {
		this.commandAddPeriodo = new CommandAddPeriodo();
		this.commandRemovePeriodo = new CommandRemovePeriodo();
		this.verificador = new VerificadorDeObjetos();
		this.controler = new Comtroler();
	}

	/**
	 * verifica se os atributos são vazios ou nullos, verifica se já existe um periodo cadastrado
	 * com esse id, verifica se existe um curso com o id passado de curso
	 * @param identificadorPeriodo - identificador do periodo
	 * @param idCurso - identificador do curso
	 * @throws H2Exception - periodo ja cadastrado ou atributo invalido
	 */
	public void add(String identificadorPeriodo, String idCurso) throws H2Exception{
		Util.verificaAtributo(identificadorPeriodo,idCurso);
		if(!verificador.comtemPeriodo(identificadorPeriodo+"-"+idCurso)){
			if(verificador.comtemCurso(idCurso)){
				commandAddPeriodo.setPerioodo(Util.factoryObject.criarPeriodo(identificadorPeriodo, idCurso));
				controler.setCommand(commandAddPeriodo);
				controler.executarCommando();
			}else{
				throw new ExceptionParametroInvalido();
			}	
		}else{
			throw new ExceptionPeriodoJaCadastrado();
		}
	}
	
	/**
	 * verific se os atributos são vazios ou nulos, verifica se o perioodo esta cadastrado
	 * no sistema, altera-se o periodo da class commandRemovePeriodo, altera o comando da class
	 * controler e pede para executar o metodo
	 * @param idPeriodo identificador do perioodo
	 * @param idCurso - identificador do curso
	 * @throws H2Exception - parametros invalidos ou periodo não cadastrado
	 */
	public void remove(String idPeriodo,String idCurso) throws H2Exception{
		Util.verificaAtributo(idPeriodo,idCurso);
		if(verificador.comtemPeriodo(idPeriodo+"-"+idCurso)){
			commandRemovePeriodo.setPeriodo(Util.factoryDao.getPeriodoDao().getPeriodos().get(idPeriodo+"-"+idCurso));
			controler.setCommand(commandRemovePeriodo);
			controler.executarCommando();
		}else{
			throw new ExceptionPeriodoNaoCadastrado();
		}
	}
	
	/**
	 * retorna o toString de periodo caso os parametros passados esteja tudo certo
	 * @param idPeriodo
	 * @param idCurso
	 * @return
	 * @throws H2Exception
	 */
	public String getPeriodo(String idPeriodo,String idCurso) throws H2Exception{
		Util.verificaAtributo(idPeriodo,idCurso);
		if(verificador.comtemPeriodo(idPeriodo+"-"+idCurso)){
			return Util.fachadaDao.getPeriodo(idPeriodo+"-"+idCurso);
		}else{
			throw new ExceptionPeriodoNaoCadastrado();
		}
	}
}
