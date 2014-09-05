package padroesDeProjeto.factory;

import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.modelo.Modelo;
import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.modelo.Sala;
import padroesDeProjeto.modelo.Turma;
import padroesDeProjeto.util.Util;

/**
 * class que cria e retona os objetos comcretos
 * @author Sidcley
 *
 */
public class FactoryObject {
	
	/**
	 * metodo que verifica qual o objeto que vai ser criado e depois de criado o retorna
	 * @param type - tipo de objeto a ser criado
	 * @param id - identificador do objeto
	 * @param nome - nome do objeto
	 * @return - professor, curso, ou sala
	 */
	public Modelo objectTypeModelo(String type,String id,String nome){
		if(type.equals("professor")){
			return new Professor(id, nome);
		}else if(type.equals("curso")){
			return new Curso(id, nome);
		}else if(type.equals("sala")){
			return new Sala(id, nome);
		}
		return null;
	}

	/**
	 * cria e retorna uma diciplina, pegase o curso e o periodo com as chaves pasada do mesmo 
	 * @param id - identificador da diciplina
	 * @param nome - nome da dicplina
	 * @param cargaHoraria - carga horaria da diciplina
	 * @param idCurso - identificador do curso
	 * @param idPeriodo - identificador do periodo
	 * @return
	 */
	public Diciplina criarDiciplina(String id, String nome,int cargaHoraria,String idCurso, String idPeriodo){
		return new Diciplina(id, nome, cargaHoraria,Util.factoryDao.getCursoDao().getCuros().get(idCurso),
				Util.factoryDao.getPeriodoDao().getPeriodos().get(idPeriodo));
	}
	
	/**
	 * cria e retorna uma sala
	 * @param id identificador da sala
	 * @param bloco - bloco onde a sala se encomtra
	 * @return
	 */
	public Sala criarSala(String id, String bloco){
		return new Sala(id, bloco);
	}
	
	/**
	 * cria e retorna um periodo, pega o objeto curso aparti de
	 * Util.factoryDao.getCursoDao().getCuros().get(idCurso)
	 * @param id - identificador do periodo
	 * @param idCurso - identificador de um curso
	 * @return um novo periodo
	 */
	public Periodo criarPeriodo(String id, String idCurso){
		return new Periodo(id, Util.factoryDao.getCursoDao().getCuros().get(idCurso));
	}
	
	/**
	 * cria e retorna um objeto Periodo, pegando os outros objetos que o compoe atravez
	 * de Util.factoryDao.ClassDao.conjunto.getObject(id)
	 * @param idTurma - identificador da turma
	 * @param idCurso - identificador do curso
	 * @param idProfessor - identificador do professor
	 * @param idDisciplina - identificador da diciplina
	 * @param idSala - identificador da sala
	 * @param idPeriodo - identificador do periodo
	 * @return
	 */
	public Turma criarTurma(String idTurma, String idCurso,String idProfessor, String idDisciplina,
			String idSala, String idPeriodo){
		return new Turma(idTurma, Util.factoryDao.getCursoDao().getCuros().get(idCurso),
				Util.factoryDao.getProfessorDao().getProfessores().get(idProfessor),
				Util.factoryDao.getDiciplinaDao().getDiciplinas().get(idDisciplina),
				Util.factoryDao.getSalaDao().getSalas().get(idSala),
				Util.factoryDao.getPeriodoDao().getPeriodos().get(idPeriodo+""+idCurso));
	}
	
}
