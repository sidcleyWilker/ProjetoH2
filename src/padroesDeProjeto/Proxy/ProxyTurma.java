package padroesDeProjeto.Proxy;

import padroesDeProjeto.CommandTurma.CommandAddTurma;
import padroesDeProjeto.CommandTurma.CommandAlteraTurma;
import padroesDeProjeto.CommandTurma.CommandRemoveTurma;
import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.Exception.ExceptionTurmaJaCadastrada;
import padroesDeProjeto.Exception.ExceptionTurmaNaoCadastrada;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.util.Comtroler;
import padroesDeProjeto.util.Util;
import padroesDeProjeto.util.VerificadorDeObjetos;

public class ProxyTurma {

	private CommandAddTurma commandAddTurma;
	private CommandAlteraTurma commandAlteraTurma;
	private CommandRemoveTurma commandRemoveTurma;
	private VerificadorDeObjetos verificador;
	private Comtroler controler;
	
	public ProxyTurma() {
		this.commandAddTurma = new CommandAddTurma();
		this.commandAlteraTurma = new CommandAlteraTurma();
		this.commandRemoveTurma = new CommandRemoveTurma();
		this.verificador = new VerificadorDeObjetos();
		this.controler = new Comtroler();
	}
	
	/**
	 * veridica todos os parametros se s�o nulos ou vazios e verifica se contem os objetos
	 * que form�o uma turma, se estiver tudo ok cria um objeto turma e manda executar o comando de
	 * Addturma
	 * @param idTurma - identificador da turma
	 * @param idCurso - identificador do curso
	 * @param idProfessor - identificador do professor
	 * @param idDisciplina - identificador da diciplina
	 * @param idSala - identificador da sala
	 * @param idPeriodo - identificador do periodo
	 * @throws H2Exception
	 */
	public void addTurma(String idTurma, String idCurso,String idProfessor, String idDisciplina,
			String idSala, String idPeriodo,int periodoAtual)throws H2Exception{
		
		Util.verificaAtributo(idTurma,idCurso,idProfessor,idDisciplina,idSala,idPeriodo);
		Util.verificaAtributoCargaHoraria(periodoAtual);
		
		if(contemObjetosTurma(idCurso, idProfessor, idDisciplina, idSala, idPeriodo)){
			if(!verificador.comtemTurma(idTurma)){
				commandAddTurma.setTurma(Util.factoryObject.criarTurma(idTurma, idCurso, idProfessor, idDisciplina, idSala, idPeriodo,periodoAtual));
				controler.setCommand(commandAddTurma);
				controler.executarCommando();
			}else{
				throw new ExceptionTurmaJaCadastrada();
			}
		}else{
			throw new ExceptionParametroInvalido();
		}
	}
	
	/**
	 * verifica se os atributos s�o vazios ou nulos, verifica se a turma esta cadastradda,
	 * verifica se o campo comtem apenas os atributos que podem ser alterados, para poder
	 * executar o commandAlteraTurma
	 * @param idTurma - identificador da turma
	 * @param campo - campo que vai mudar
	 * @param novoValor o novo valor para campo
	 * @throws H2Exception
	 */
	public void alteraTurma(String idTurma, String campo, String novoValor) throws H2Exception{
		Util.verificaAtributo(idTurma,campo,novoValor);
		if(verificador.comtemTurma(idTurma)){
			if(campo.equals("professor") || campo.equals("diciplina") || campo.equals("sala")
					|| campo.equals("periodo")){
				commandAlteraTurma.setTurma(Util.factoryDao.getTurmaDao().getTurmas().get(idTurma));
				commandAlteraTurma.setCampo(campo);
				commandAlteraTurma.setNovoValor(novoValor);
				controler.setCommand(commandAlteraTurma);
				controler.executarCommando();
			}else{
				throw new ExceptionParametroInvalido();
			}
		}else{
			throw new ExceptionTurmaNaoCadastrada();
		}
	}
	
	/**
	 * verifica o atributo, verifica se ele esta cadastrado no sistema, para poder fazer a remo��o
	 * dele no sistema
	 * @param idTurma - identificador da turma
	 * @throws H2Exception
	 */
	public void removeTurma(String idTurma) throws H2Exception{
		Util.verificaAtributo(idTurma);
		if(verificador.comtemTurma(idTurma)){
			commandRemoveTurma.setTurma(Util.factoryDao.getTurmaDao().getTurmas().get(idTurma));
			controler.setCommand(commandRemoveTurma);
			controler.executarCommando();
		}else{
			throw new ExceptionTurmaNaoCadastrada();
		}
	}
	
	/**
	 * verifica se os objetos que compoe uma turma j� est�o cadastrados no sistema atravez 
	 * de seu identificador
	 * @param idCurso - identificador do curso
	 * @param idProfessor - identificador do professor
	 * @param idDisciplina - identificador da diciplina
	 * @param idSala - identificador da sala
	 * @param idPeriodo - identificador do periodo
	 * @return - true ou false
	 */
	private boolean contemObjetosTurma(String idCurso,String idProfessor,
			String idDisciplina,String idSala, String idPeriodo){
		if(Util.factoryDao.getCursoDao().getCuros().containsKey(idCurso) &&
				Util.factoryDao.getProfessorDao().getProfessores().containsKey(idProfessor)&&
				Util.factoryDao.getDiciplinaDao().getDiciplinas().containsKey(idDisciplina)&&
				Util.factoryDao.getSalaDao().getSalas().containsKey(idSala)&&
				Util.factoryDao.getPeriodoDao().getPeriodos().containsKey(idPeriodo+"-"+idCurso)){
			return true;
		}
		
		return false;
	}

	/**
	 * verifica o atributo passado, verifica se existe uma turma cadastrado no sistema
	 * para poder retorna o seu toString
	 * @param idTurma - identificador da turma
	 * @return - toString
	 * @throws H2Exception
	 */
	public String getTurma(String idTurma) throws H2Exception {
		Util.verificaAtributo(idTurma);
		if(verificador.comtemTurma(idTurma)){
			return Util.fachadaDao.getTurma(idTurma);
		}else{
			throw new ExceptionTurmaNaoCadastrada();
		}
		
	}
}
