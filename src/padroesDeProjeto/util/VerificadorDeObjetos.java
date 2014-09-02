package padroesDeProjeto.util;

public class VerificadorDeObjetos {

	/**
	 * verifica se existe um professor cadastrado no sistema com esse chave passada
	 * @param key - identificador do professor
	 * @return - true se existe, false caso contrario
	 */
	public boolean contemProfessor(String key){
		if(Util.factoryDao.getProfessorDao().getProfessores().containsKey(key)){
			return true;
		}
		return false;
	}

	/**
	 * verifica se existe uma diciplina cadastrada no sistema com a chave passada
	 * @param key - identificador de uma diciplina
	 * @return - true se existe, false caso contrario
	 */
	public boolean comtemDiciplina(String key){
		if(Util.factoryDao.getDiciplinaDao().getDiciplinas().containsKey(key)){
			return true;
		}
		return false;
	}
	
	/**
	 * verifica se existe um curso cadastrado no sistema com a chave passada
	 * @param - key identificador do curso
	 * @return - true se existe, false caso contrario
	 */
	public boolean comtemCurso(String key){
		if( Util.factoryDao.getCursoDao().getCuros().containsKey(key)){
			return true;
		}
		return false;
	}

	/**
	 * verifica se existe um priodo cadastrado no sistema com a chave passada
	 * @param - key identificador do periodo
	 * @return - true se existe, false caso contrario
	 */
	public boolean comtemPeriodo(String key){
		if(Util.factoryDao.getPeriodoDao().getPeriodos().containsKey(key)){
			return true;
		}
		return false;
	}
	
	/**
	 * verifica se existe uma sala cadastrada no sistema com a chave passada
	 * @param key - identificador da sala
	 * @return - true se existe, false caso contrario
	 */
	public boolean comtemSala(String key){
		if(Util.factoryDao.getSalaDao().getSalas().containsKey(key)){
			return true;
		}
		return false;
	}
	
	/**
	 * verifica se existe uma turma cadastrada no sistema com a chave passada
	 * @param key - identificador da turma
	 * @return - true ou false
	 */
	public boolean comtemTurma(String key){
		if(Util.factoryDao.getTurmaDao().getTurmas().containsKey(key)){
			return true;
		}
		return false;
	}
}
