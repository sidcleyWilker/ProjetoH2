package padroesDeProjeto.factory;

import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.modelo.Modelo;
import padroesDeProjeto.modelo.Periodo;
import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.modelo.Sala;
import padroesDeProjeto.util.Util;


public class FactoryObject {
	

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

	public Diciplina criarDiciplina(String id, String nome,int cargaHoraria,String idCurso, String idPeriodo){
		return new Diciplina(id, nome, cargaHoraria, Util.bd.getCursos().get(idCurso), Util.bd.getPeriodos().get(idPeriodo));
	}
}
