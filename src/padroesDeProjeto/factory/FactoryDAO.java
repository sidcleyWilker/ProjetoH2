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
	 * cria e retorna um objeto do tipo ProfessorDAO
	 * @return
	 */
	public ProfessorDAO getProfessorDao(){
		return new ProfessorDAO();
	}
	/**
	 * cria e retorna um objeto do tipo CursoDao
	 * @return
	 */
	public CursoDAO getCursoDao(){
		return new CursoDAO();
	}
	/**
	 * cria e retorna um objeto do tipo SalaDao
	 * @return
	 */
	public SalaDAO getSalaDao(){
		return new SalaDAO();
	}
	
	/**
	 * cria e retorna um objeto do tipo DiciplinaDao
	 * @return
	 */
	public DiciplinaDAO getDiciplinaDao(){
		return new DiciplinaDAO();
	}
	
	/**
	 * cria e retorna um objeto do tipo PeriodoDao
	 * @return
	 */
	public PeriodoDAO getPeriodoDao(){
		return new PeriodoDAO();
	}
	
	/**
	 * cria e retorna um objeto do tipo TurmaDao
	 * @return
	 */
	public TurmaDAO getTurmaDao(){
		return new TurmaDAO();
	}
}
