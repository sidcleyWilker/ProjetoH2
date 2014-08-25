package padroesDeProjeto.modelo;

public abstract class Modelo {
	
	protected String id;
	protected String nome;
	
	public Modelo(String id, String nome){
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public abstract String toString();

}

