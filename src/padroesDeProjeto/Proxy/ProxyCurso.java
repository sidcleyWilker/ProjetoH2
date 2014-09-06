package padroesDeProjeto.Proxy;

import padroesDeProjeto.CommandCurso.CommandAddCurso;
import padroesDeProjeto.CommandCurso.CommandAlteraCurso;
import padroesDeProjeto.CommandCurso.CommandRemoveCurso;
import padroesDeProjeto.Exception.ExceptionCursoJaCadastrado;
import padroesDeProjeto.Exception.ExceptionCursoNaoCadastrado;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.modelo.Turma;
import padroesDeProjeto.util.Comtroler;
import padroesDeProjeto.util.Util;
import padroesDeProjeto.util.VerificadorDeObjetos;

public class ProxyCurso {

	private CommandAddCurso commandAddCurso;
	private CommandAlteraCurso commandAlteraCurso;
	private CommandRemoveCurso commandRemoveCurso;
	private VerificadorDeObjetos verificador;
	private Comtroler controler;
	
	
	public ProxyCurso() {
		this.commandAddCurso = new CommandAddCurso();
		this.commandAlteraCurso = new CommandAlteraCurso();
		this.commandRemoveCurso = new CommandRemoveCurso();
		this.verificador = new VerificadorDeObjetos();
		this.controler = new Comtroler();
	}
	
	/**
	 * verifica os atributos passados, verifica se já existe um curso com esse id,
	 * cria um curso, altera o command da class controle e pede para executar o command
	 * @param idrCurso - identificador do curso
	 * @param nome - nome do curso
	 * @throws H2Exception - curso já cadastrado ou parametros invalids
	 */
	public void add(String idrCurso, String nome) throws H2Exception{
		Util.verificaAtributo(idrCurso,nome);
		if(!verificador.comtemCurso(idrCurso)){
			commandAddCurso.setCurso((Curso) Util.factoryObject.objectTypeModelo("curso", idrCurso, nome));
			controler.setCommand(commandAddCurso);
			controler.executarCommando();
		}else{
			throw new ExceptionCursoJaCadastrado();
		}
	}
	
	/**
	 *verifica os atributos passados, verifica se já existe um curso com esse id
	 *para fazer a alteração, pega o objeto do sistema com esse id manda para a
	 * class commadAlteraCurso altera o command da class controle e pede para executar  
	 * @param id - identificador do curso
	 * @param novoValor - novo valor para o nomo do curso
	 * @throws H2Exception
	 */
	public void alterar(String id, String novoValor) throws H2Exception{
		Util.verificaAtributo(id,novoValor);
		if(verificador.comtemCurso(id)){
			commandAlteraCurso.setCurso(Util.factoryDao.getCursoDao().getCuros().get(id));
			commandAlteraCurso.setNovoValor(novoValor);
			controler.setCommand(commandAlteraCurso);
			controler.executarCommando();
		}else{
			throw new ExceptionCursoNaoCadastrado();
		}
	}
	
	/**
	 * verifica o atributo,verifica se ele esta no sistema, executa o commandRemove curso,
	 * e remove em cascata os objetos ligados ou curso
	 * @param id
	 * @throws H2Exception
	 */
	public void remove(String id) throws H2Exception{
		Util.verificaAtributo(id);
		if(verificador.comtemCurso(id)){
			auxRemoveCurso(id);
			commandRemoveCurso.setCurso(Util.factoryDao.getCursoDao().getCuros().get(id));
			controler.setCommand(commandRemoveCurso);
			controler.executarCommando();
		}else{
			throw new ExceptionCursoNaoCadastrado();
		}
	}

	/**
	 * auxilhia o metodo de remover um curso, removendo todos os periodos,turmas e diciplinas
	 * associadas a aquele curso
	 * @param - idCurso identificador do curso
	 */
	private void auxRemoveCurso(String idCurso){
		/*
		 * verifica se o id do curso de periodo é igual ao id passado para fazer a remoção
		 *  do periodo ao final salva-se a class 
		 */
		for (Periodo p : Util.factoryDao.getPeriodoDao().getPeriodos().values()){
			if(p.getCurso().getId().equals(idCurso)){
				Util.factoryDao.getPeriodoDao().getPeriodos().remove(p.getId());
				Util.bd.salvar();
			}
		}
		for(Turma t : Util.factoryDao.getTurmaDao().getTurmas().values()){
			Util.factoryDao.getTurmaDao().getTurmas().remove(t.getId());
			Util.bd.salvar();
		}
		for (Diciplina d : Util.factoryDao.getDiciplinaDao().getDiciplinas().values()){
			Util.factoryDao.getDiciplinaDao().getDiciplinas().remove(d.getId());
			Util.bd.salvar();
		}
	}
	
	/**
	 * retorna o toString de um curso se ele estiver cadastrado no sistema
	 * @param id- identificador do curso
	 * @return - toString do curso
	 * @throws H2Exception- curso não cadastrado no sistema
	 */
	public String getCurso(String id) throws H2Exception{
		Util.verificaAtributo(id);
		if(verificador.comtemCurso(id)){
			return Util.fachadaDao.getCurso(id);
		}else{
			throw new ExceptionCursoNaoCadastrado();
		}
	}
}
