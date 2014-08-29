package padroesDeProjeto.objetosDAO;

import java.util.Map;

import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.modelo.Diciplina;
import padroesDeProjeto.util.Util;

public class DiciplinaDAO {

	
	
	public void criar(Diciplina diciplina){
		Util.bd.load();
		Util.bd.getDiciplinas().put(diciplina.getId(), diciplina);
		Util.bd.salvar();
	}
	
	public Map<String,Diciplina> getDiciplinas(){
		Util.bd.load();
		return Util.bd.getDiciplinas();
	}
	
	public void atualizar(String keyDiciplina, String atributo,String novoValor){
		Util.bd.load();
		if( atributo.equals("cargaHoraria") ){
				Util.bd.getDiciplinas().get(keyDiciplina).setCargaHoraria(Integer.parseInt(novoValor));
		}else if(atributo.equals("nome")){
			Util.bd.getDiciplinas().get(keyDiciplina).setNome(novoValor);
		}
		Util.bd.salvar();
	}
	
	public void remove(String key){
		Util.bd.load();
		Util.bd.getDiciplinas().remove(key);
		Util.bd.salvar();
	}
}
