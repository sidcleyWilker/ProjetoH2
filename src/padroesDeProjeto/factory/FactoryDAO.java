package padroesDeProjeto.factory;


import padroesDeProjeto.objetosDAO.CursoDAO;
import padroesDeProjeto.objetosDAO.DiciplinaDAO;
import padroesDeProjeto.objetosDAO.ModeloDAO;
import padroesDeProjeto.objetosDAO.PeriodoDAO;
import padroesDeProjeto.objetosDAO.ProfessorDAO;
import padroesDeProjeto.objetosDAO.SalaDAO;
import padroesDeProjeto.objetosDAO.TurmaDAO;
/**
 * class que cria e retorna os objetos DAO 
 * @author Sidcley
 *
 */
public class FactoryDAO {

	/**
	 * factory metodo verifica o typo de objeto a ser criado e retorna um aparte do tipo passado 
	 * @param type - tipo do objecto a ser criado
	 * @return - um objeto do tipo modeloDAO
	 */
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

	
	public DiciplinaDAO getDiciplinaDao(){
		return new DiciplinaDAO();
	}
	
	
	public PeriodoDAO getPeriodoDao(){
		return new PeriodoDAO();
	}
	
	public TurmaDAO getTurmaDao(){
		return new TurmaDAO();
	}
}
