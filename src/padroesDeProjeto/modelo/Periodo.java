package padroesDeProjeto.modelo;

public class Periodo {

	private String id;
	private Curso curso;
	
	public Periodo(String id, Curso curso) {
		this.id = id;
		this.curso = curso;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString(){
		return curso.getId()+" - "+id;
	}
}
