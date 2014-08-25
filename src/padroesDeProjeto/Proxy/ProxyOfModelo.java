package padroesDeProjeto.Proxy;

import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.factory.FactoryDAO;
import padroesDeProjeto.objetosDAO.CursoDAO;
import padroesDeProjeto.objetosDAO.ProfessorDAO;
import padroesDeProjeto.objetosDAO.SalaDAO;
import padroesDeProjeto.util.Util;

public class ProxyOfModelo {

	private  FactoryDAO factoryDAO;
	/**
	 * 
	 * @param object
	 * @param id
	 * @param nome
	 * @throws H2Exception
	 */
	public void add(String object,String id,String nome) throws H2Exception{
		Util.verificaAtributo(id);
		Util.verificaAtributo(nome);
		if(object.equals("professor")){
			if(verificaCadastro(object,id)){
				//throw new exception Professor já cadastrado.
			}else{
				// add professor ao sistema
			}
		}else if(object.equals("curso")){
			if(verificaCadastro(object,id)){
				//throw new exception Professor já cadastrado.
			}else{
				// add professor ao sistema
			}
		}else if(object.equals("sala")){
			if(verificaCadastro(object,id)){
				//throw new exception Professor já cadastrado.
			}else{
				// add professor ao sistema
			}
		}
		
	}
	
	/**
	 * 
	 * @param object
	 * @param id
	 * @param nome
	 * @throws H2Exception
	 */
	public void altera(String object,String id,String nome) throws H2Exception{
		Util.verificaAtributo(id);
		Util.verificaAtributo(nome);
		if(object.equals("professor")){
			if(verificaCadastro(object,id)){
				// alterar profesor
			}else{
				// lança exception
			}
		}else if(object.equals("curso")){
			if(verificaCadastro(object,id)){
				//alterar curso
			}else{
				// throw new exception
			}
		}else if(object.equals("sala")){
			if(verificaCadastro(object,id)){
				// alterar
			}else{
				// throw new exception
			}
		}
		
	}
	
	public void remove(String object,String id) throws H2Exception{
		Util.verificaAtributo(id);
		if(object.equals("professor")){
			if(verificaCadastro(object,id)){
				// remove profesor
			}else{
				// lança exception
			}
		}else if(object.equals("curso")){
			if(verificaCadastro(object,id)){
				//remove curso
			}else{
				// throw new exception
			}
		}else if(object.equals("sala")){
			if(verificaCadastro(object,id)){
				// remove sala
			}else{
				// throw new exception
			}
		}
	}
	
	/**
	 * 
	 * @param object
	 * @param id
	 * @return
	 */
	private boolean verificaCadastro(String object,String id){
		if (object.equals("professor")){
			if(((ProfessorDAO)factoryDAO.getObjectDAOModelo("professor")).getProfessores().containsKey(id)){
				return true;
			}
		}else if(object.equals("curso")){
			if(((CursoDAO) factoryDAO.getObjectDAOModelo("curso")).getCuros().containsKey(id)){
				return true;
			}
		}else if(object.equals("sala")){
			if(((SalaDAO) factoryDAO.getObjectDAOModelo("sala")).getSalas().containsKey(id)){
				return true;
			}
		}
		return false;
	}
}
