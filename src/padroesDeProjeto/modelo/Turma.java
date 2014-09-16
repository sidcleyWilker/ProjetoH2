package padroesDeProjeto.modelo;

public class Turma {

	private String id;
	private Curso curso;
	private Professor professor;
	private Diciplina diciplina;
	private Sala sala;
	private Periodo periodo;
	private int periodoAtual;
	
	public Turma(String id, Curso curso, Professor professor, Diciplina diciplina,
			Sala sala, Periodo periodo,int periodoAtual) {
		this.id = id;
		this.curso = curso;
		this.professor = professor;
		this.diciplina = diciplina;
		this.sala = sala;
		this.periodo = periodo;
		this.periodoAtual = periodoAtual;
	}
	
	public Turma(){
		
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
	
	public int getPeriodoAtual() {
		return periodoAtual;
	}

	public void setPeriodoAtual(int periodoAtual) {
		this.periodoAtual = periodoAtual;
	}

	@Override
	public String toString(){
		return id+"-"+professor.getId()+"-"+curso.getId()+"-"+diciplina.getId()+"-"+
	periodo.getId()+"-"+sala.getId()+"- cursando periodo: "+periodoAtual;
	}

}
