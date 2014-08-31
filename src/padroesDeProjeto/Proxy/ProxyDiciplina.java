package padroesDeProjeto.Proxy;

import padroesDeProjeto.CommandDiciplina.CommandAddDiciplina;
import padroesDeProjeto.CommandDiciplina.CommandAlteraDiciplina;
import padroesDeProjeto.CommandDiciplina.CommandRemoveDiciplina;
import padroesDeProjeto.Exception.ExceptionDiciplinaJaCadastrada;
import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.util.Comtroler;
import padroesDeProjeto.util.Util;
import padroesDeProjeto.util.VerificadorDeObjetos;

public class ProxyDiciplina {

	private CommandAddDiciplina commandAddDciciplina;
	private CommandAlteraDiciplina commandAlteraDiciplina;
	private CommandRemoveDiciplina commandRemoveDiciplina;
	private Comtroler controle;
	private VerificadorDeObjetos verificador; 
	
	public ProxyDiciplina(CommandAddDiciplina commandAddDciciplina,
			CommandAlteraDiciplina commandAlteraDiciplina,
			CommandRemoveDiciplina commandRemoveDiciplina, Comtroler controle) {
		this.commandAddDciciplina = commandAddDciciplina;
		this.commandAlteraDiciplina = commandAlteraDiciplina;
		this.commandRemoveDiciplina = commandRemoveDiciplina;
		this.controle = controle;
		this.verificador = new VerificadorDeObjetos();
	}
	
	/**
	 * verifica todos os atributos se são nulos ou vazios, verifica se já contem uma diciplina cadastrada 
	 * com esse id, verifica se estão cadastrados no sistema o curso e o periodo que vai compor essa diciplina
	 * altera a diciplina da class CommandAddDiciplina, altera o commando da class controle e pede para ela
	 * executar o metodo executar
	 * @param idDisciplina - identificador da diciplina
	 * @param nomeDisciplina - nome da diciplina
	 * @param cargaHoraria - a quantidades de hora dessa diciplina
	 * @param idCurso - o identificador de um curso 
	 * @param idPeriodo - o identificador de um periodo
	 * @throws H2Exception
	 * 					parametros invalidos e diciplina já cadastrada
	 */
	public void addDiciplina(String idDisciplina,String nomeDisciplina, int cargaHoraria, String idCurso,
			String idPeriodo) throws H2Exception{
		Util.verificaAtributo(idDisciplina,nomeDisciplina,idCurso,idPeriodo);
		if(!verificador.comtemDiciplina(idDisciplina)){
			if (verificador.comtemCurso(idCurso) && verificador.comtemPeriodo(idPeriodo)){
				commandAddDciciplina.setDicipina(Util.factoryObject.criarDiciplina(idDisciplina, nomeDisciplina, cargaHoraria, idCurso, idPeriodo));
				controle.setCommand(commandAddDciciplina);
				controle.executarCommando();
			}else{
				throw new ExceptionParametroInvalido();
			}
		}else{
			throw new ExceptionDiciplinaJaCadastrada();
		}
	}
	
	/**
	 * altera o atributo de uma diciplina atravez da sua identificação e do curso a qual ela pertence,
	 * verifica-se se os campos são nullos ou vazios, verifica se existe no sistema o curso ea diciplina
	 * que foi passado as suas chaves de identificação
	 * @param idCurso - identificador do curso
	 * @param sigla - identificador da diciplina
	 * @param atributo - atributo que vai mudar
	 * @param novoValor - o novo valor para o atributo
	 * @throws H2Exception - parametros invalidos
	 */
	public void alteraDiciplina(String idCurso, String sigla, String atributo,
			String novoValor) throws H2Exception{
		Util.verificaAtributo(idCurso,sigla,atributo,novoValor);
		if(verificador.comtemCurso(idCurso) && verificador.comtemDiciplina(sigla)){
			// PEGAR A DICIPLINA QUE CONTEM UM CURSO E VERIFICAR SE O CURSO PASSASO É IGUAL OU CURSO DA DICIPLINA
			if(Util.bd.getDiciplinas().get(sigla).getCurso().equals(Util.bd.getCursos().get(idCurso))){
				commandAlteraDiciplina.setKeyDiciplina(sigla);
				commandAlteraDiciplina.setAtributo(atributo);
				commandAlteraDiciplina.setNovoValor(novoValor);
				controle.setCommand(commandAlteraDiciplina);
				controle.executarCommando();
			}else{
				// a diciplina não é desse curso
				throw new ExceptionParametroInvalido();
			}
		}else{
			throw new ExceptionParametroInvalido();
		}
	}

}
