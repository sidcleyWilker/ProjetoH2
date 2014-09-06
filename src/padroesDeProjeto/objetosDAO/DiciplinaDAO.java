package padroesDeProjeto.objetosDAO;

import java.util.Map;

import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.util.Util;

public class DiciplinaDAO {

	
	/**
	 * carega e adiciona uma diciplina ao sistema
	 * @param diciplina - objeto diciplina
	 */
	public void criar(Diciplina diciplina){
		Util.bd.load();
		Util.bd.getDiciplinas().put(diciplina.getId(), diciplina);
		Util.bd.salvar();
	}
	
	/**
	 * carega e retorna o map contendo todas as diciplinas cadastradas
	 * @return - map das diciplinas
	 */
	public Map<String,Diciplina> getDiciplinas(){
		Util.bd.load();
		return Util.bd.getDiciplinas();
	}
	
	/**
	 * carega e faz a alteração de um atriboto em uma diciplina e depois salva no sistema
	 * @param keyDiciplina - chave da diciplina
	 * @param atributo - atrinuto que vai mudar
	 * @param novoValor - o novo valor para o atributo
	 */
	public void atualizar(String keyDiciplina, String atributo,String novoValor){
		Util.bd.load();
		if( atributo.equals("cargaHoraria") ){
				Util.bd.getDiciplinas().get(keyDiciplina).setCargaHoraria(Integer.parseInt(novoValor));
		}else if(atributo.equals("nome")){
			Util.bd.getDiciplinas().get(keyDiciplina).setNome(novoValor);
		}
		Util.bd.salvar();
	}
	
	/**
	 * carega, remove uma diciplina e depois salva
	 * @param key - chave da diciplina
	 */
	public void remove(String key){
		Util.bd.load();
		Util.bd.getDiciplinas().remove(key);
		Util.bd.salvar();
	}
}
