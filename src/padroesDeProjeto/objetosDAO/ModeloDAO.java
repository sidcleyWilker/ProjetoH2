package padroesDeProjeto.objetosDAO;


import padroesDeProjeto.modelo.Curso;
import padroesDeProjeto.modelo.Modelo;
import padroesDeProjeto.modelo.Professor;
import padroesDeProjeto.modelo.Sala;
import padroesDeProjeto.util.Util;


public abstract class ModeloDAO {

	/**
	 * adiciona um objeto ao banco de dados podendo ser somente um professor, um curso ou uma sala,
	 * @param object - objeto que idetifica qual objeto vai ser adicionado e onde vai ser adicionado
	 * @param objectModelo - um objeto comcreto do tipo Modelo 
	 */
	public void criar(String object,Modelo objectModelo){
		Util.bd.load();
		if(object.equals("professor")){
			Util.bd.getProfessores().put(objectModelo.getId(),(Professor) objectModelo);
		}else if(object.equals("curso")){
			Util.bd.getCursos().put(objectModelo.getId(),(Curso) objectModelo);
		}else if(object.equals("sala")){
			Util.bd.getSalas().put(objectModelo.getId(),(Sala) objectModelo);
		}
		Util.bd.salvar();
	}
	
	public void atualizar(String object,String id, String novoValor){
		Util.bd.load();
		if(object.equals("professor")){
			Util.bd.getProfessores().get(id).setNome(novoValor);
		}else if(object.equals("curso")){
			Util.bd.getCursos().get(id).setNome(novoValor);
		}else if(object.equals("sala")){
			Util.bd.getSalas().get(id).setNome(novoValor);
		}
		Util.bd.salvar();
	}
	
	public void remover(String object,String id){
		Util.bd.load();
		if(object.equals("professor")){
			Util.bd.getProfessores().remove(id);
		}else if(object.equals("curso")){
			Util.bd.getCursos().remove(id);
		}else if(object.equals("sala")){
			Util.bd.getSalas().remove(id);
		}
		Util.bd.salvar();
	}
	
}
