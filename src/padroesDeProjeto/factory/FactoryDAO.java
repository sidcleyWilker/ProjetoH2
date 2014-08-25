package padroesDeProjeto.factory;


import padroesDeProjeto.objetosDAO.CursoDAO;
import padroesDeProjeto.objetosDAO.ModeloDAO;
import padroesDeProjeto.objetosDAO.ProfessorDAO;
import padroesDeProjeto.objetosDAO.SalaDAO;

public abstract class FactoryDAO {

	public ModeloDAO getObjectDAOModelo(String type){
		if(type.equals("professorDao")){
			return new ProfessorDAO();
		}else if (type.equals("cursoDao")){
			return new CursoDAO();
		}else if(type.equals("salaDao")){
			return new SalaDAO();
		}
		return null;
	} 

	
}
