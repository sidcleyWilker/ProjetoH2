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
	
	
	public void addTurma(String idTurma, String idCurso,String idProfessor, String idDisciplina,
			String idSala, String idPeriodo)throws H2Exception{
		Util.verificaAtributo(idTurma,idCurso,idProfessor,idDisciplina,idSala,idPeriodo);
		if(contemObjetosTurma(idCurso, idProfessor, idDisciplina, idSala, idPeriodo)){
			if(!verificador.comtemTurma(idTurma)){
				commandAddTurma.setTurma(Util.factoryObject.criarTurma(idTurma, idCurso, idProfessor, idDisciplina, idSala, idPeriodo));
				controler.setCommand(commandAddTurma);
				controler.executarCommando();
			}else{
				throw new ExceptionTurmaJaCadastrada();
			}
		}else{
			throw new ExceptionParametroInvalido();
		}
	}
	
	
	public void alteraTurma(String idTurma, String campo, String novoValor) throws H2Exception{
		Util.verificaAtributo(idTurma,campo,novoValor);
		if(verificador.comtemTurma(idTurma)){
			if(campo.equals("professor") || campo.equals("diciplina") || campo.equals("sala")
					|| campo.equals("periodo")){
				throw new ExceptionParametroInvalido();
			}else{
				commandAlteraTurma.setTurma(Util.factoryDao.getTurmaDao().getTurmas().get(idTurma));
				commandAlteraTurma.setCampo(campo);
				commandAlteraTurma.setNovoValor(novoValor);
				controler.setCommand(commandAlteraTurma);
				controler.executarCommando();
			}
		}else{
			throw new ExceptionTurmaNaoCadastrada();
		}
	}
	
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
	 * verifica se os objetos que compoe uma turma já estão cadastrados no sistema atravez 
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

	public String getTurma(String idTurma) throws H2Exception {
		Util.verificaAtributo(idTurma);
		if(verificador.comtemTurma(idTurma)){
			return Util.fachadaDao.getTurma(idTurma);
		}
		return null;
	}
}
