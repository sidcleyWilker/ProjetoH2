package padroesDeProjeto.factory;


import padroesDeProjeto.objetosDAO.AlocacaoDAO;
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

	private final ProfessorDAO professor = new ProfessorDAO();
	private final CursoDAO curso = new CursoDAO();
	private final SalaDAO sala = new SalaDAO();
	private final DiciplinaDAO diciplina = new DiciplinaDAO();
	private final PeriodoDAO periodo = new PeriodoDAO();
	private final TurmaDAO turma = new TurmaDAO();
	private final AlocacaoDAO alocacao = new AlocacaoDAO();
	/**
	 * cria e retorna um objeto do tipo ProfessorDAO
	 * @return
	 */
	public ProfessorDAO getProfessorDao(){
		return professor;
	}
	/**
	 * cria e retorna um objeto do tipo CursoDao
	 * @return
	 */
	public CursoDAO getCursoDao(){
		return curso;
	}
	/**
	 * cria e retorna um objeto do tipo SalaDao
	 * @return
	 */
	public SalaDAO getSalaDao(){
		return sala;
	}
	
	/**
	 * cria e retorna um objeto do tipo DiciplinaDao
	 * @return
	 */
	public DiciplinaDAO getDiciplinaDao(){
		return diciplina;
	}
	
	/**
	 * cria e retorna um objeto do tipo PeriodoDao
	 * @return
	 */
	public PeriodoDAO getPeriodoDao(){
		return periodo;
	}
	
	/**
	 * cria e retorna um objeto do tipo TurmaDao
	 * @return
	 */
	public TurmaDAO getTurmaDao(){
		return turma;
	}
	
	public AlocacaoDAO getAlocacaoDao(){
		return alocacao;
	}
}
