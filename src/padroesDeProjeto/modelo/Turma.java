package padroesDeProjeto.modelo;

public class Turma {

	private String id;
	private Curso curso;
	private Professor professor;
	private Diciplina diciplina;
	private Sala sala;
	private Periodo periodo;
	
	public Turma(String id, Curso curso, Professor professor, Diciplina diciplina,
			Sala sala, Periodo periodo) {
		this.id = id;
		this.curso = curso;
		this.professor = professor;
		this.diciplina = diciplina;
		this.sala = sala;
		this.periodo = periodo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Diciplina getDiciplina() {
		return diciplina;
	}
	public void setDiciplina(Diciplina diciplina) {
		this.diciplina = diciplina;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	@Override
	public String toString(){
		return id+""+"";
	}

}
