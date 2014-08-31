package padroesDeProjeto.modelo;

public class Curso extends Modelo{

	public Curso(String id, String nome) {
		super(id, nome);
	}
	
	public Curso(){
		
	}

	@Override
	public String toString() {
		return getId()+" - "+getNome();
	}

}
