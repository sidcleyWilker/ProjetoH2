package padroesDeProjeto.modelo;

public class Professor extends Modelo{

	public Professor(String id, String nome) {
		super(id, nome);
		// TODO Auto-generated constructor stub
	}

	public Professor(){
		
	}
	@Override
	public String toString() {
		return getId()+" - "+getNome();
	}

	
	
}
