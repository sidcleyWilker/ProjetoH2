package padroesDeProjeto.util;

public class VerificadorDeObjetos {

	/**
	 * verifica se existe um professor cadastrado no sistema com esse chave passada
	 * @param key - identificador do professor
	 * @return true se existe, false caso contrario
	 */
	public boolean contemProfessor(String key){
		if(Util.bd.getProfessores().containsKey(key)){
			return true;
		}
		return false;
	}

	/**
	 * verifica se existe uma diciplina cadastrada no sistema com a chave passada
	 * @param key - identificador de uma diciplina
	 * @return true se existe, false caso contrario
	 */
	public boolean comtemDiciplina(String key){
		if(Util.bd.getDiciplinas().containsKey(key)){
			return true;
		}
		return false;
	}
	
	/**
	 * verifica se existe um curso cadastrado no sistema com a chave passada
	 * @param key identificador do curso
	 * @return
	 */
	public boolean comtemCurso(String key){
		if(Util.bd.getCursos().containsKey(key)){
			return true;
		}
		return false;
	}

	/**
	 * verifica se existe um priodo cadastrado no sistema com a chave passada
	 * @param key
	 * @return
	 */
	public boolean comtemPeriodo(String key){
		if(Util.bd.getPeriodos().containsKey(key)){
			return true;
		}
		return false;
	}
}
