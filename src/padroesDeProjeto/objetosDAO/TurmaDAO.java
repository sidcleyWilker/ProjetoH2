package padroesDeProjeto.objetosDAO;

import java.util.Map;

import padroesDeProjeto.modelo.Turma;
import padroesDeProjeto.util.Util;

public class TurmaDAO {

	public TurmaDAO() {
	}

	/**
	 * carega adiciona e salva uma turma no sistema
	 * @param turma - objeto do tipo turma
	 */
	public void criar(Turma turma){
		Util.bd.load();
		Util.bd.getTurmas().put(turma.getId(), turma);
		Util.bd.salvar();
	}

	/**
	 *carega e retorna o map contendo todas as turmas cadastradas no sistema 
	 * @return
	 */
	public Map<String,Turma> getTurmas(){
		Util.bd.load();
		return Util.bd.getTurmas();
	}
	
	/**
	 * altera um atributo de uma turma de acordo com o campo a ser alterado 
	 * a parti do seu id
	 * @param id - identificador da turma
	 * @param campo - campo que vai ser alterado
	 * @param novovalor - um novo objeto que vai subistituir
	 */
	public void alterar(String id,String campo,String novovalor){
		Util.bd.load();
		if(campo.equals("professor")){
			Util.bd.getTurmas().get(id).setProfessor(Util.bd.getProfessores().get(novovalor));
		}else if(campo.equals("diciplina")){
			Util.bd.getTurmas().get(id).setDiciplina(Util.bd.getDiciplinas().get(novovalor));
		}else if(campo.equals("sala")){
			Util.bd.getTurmas().get(id).setSala(Util.bd.getSalas().get(novovalor));
		}else if(campo.equals("periodo")){
			Util.bd.getTurmas().get(id).setPeriodo(Util.bd.getPeriodos().get(novovalor));
		}else if(campo.equals("periodoAtual")){
			Util.bd.getTurmas().get(id).setPeriodoAtual(Integer.parseInt(novovalor));
			}
		Util.bd.salvar();
	}
	
	/** 
	 * carega, remove uma turma e depois salva as alteraões
	 * @param key
	 */
	public void remove(String key){
		Util.bd.load();
		Util.bd.getTurmas().remove(key);
		Util.bd.salvar();
	}
}
