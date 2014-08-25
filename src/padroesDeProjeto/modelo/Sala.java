package padroesDeProjeto.modelo;

public class Sala extends Modelo{

	public Sala(String id, String nome) {
		super(id, nome);
	}

	@Override
	public String toString() {
		return id+" - "+nome;
	}

}
