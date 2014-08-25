package padroesDeProjeto.modelo;

public class Professor extends Modelo{

	public Professor(String id, String nome) {
		super(id, nome);
	}

	@Override
	public String toString() {
		return id+" - "+nome;
	}

}
