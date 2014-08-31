package padroesDeProjeto.modelo;

public class Sala extends Modelo{

	public Sala(String id, String nome) {
		super(id, nome);
	}

	public Sala(){
		
	}
	
	@Override
	public String toString() {
		return getId()+" - "+getNome();
	}

}
