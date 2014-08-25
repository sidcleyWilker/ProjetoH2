package padroesDeProjeto.factory;

import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.modelo.Modelo;
import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.modelo.Sala;


public abstract class FactoryObject {
	

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
}
