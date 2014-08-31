package padroesDeProjeto.factory;

import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.modelo.Modelo;
import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.modelo.Sala;
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
}
