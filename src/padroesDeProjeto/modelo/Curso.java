package padroesDeProjeto.modelo;

public class Curso extends Modelo{

	public Curso(String id, String nome) {
		super(id, nome);
	}

	@Override
	public String toString() {
		return id+" - "+nome;
	}

}
