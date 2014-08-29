package padroesDeProjeto.modelo;

public class Diciplina extends Modelo{

	private int cargaHoraria;
	private Curso curso;
	private Periodo periodo;
	
	public Diciplina(String id, String nome,int cargaoraria,Curso curso, Periodo periodo) {
		super(id, nome);
		this.cargaHoraria = cargaoraria;
		this.curso = curso;
		this.periodo = periodo;
	}

	
	public int getCargaHoraria() {
		return cargaHoraria;
	}


	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public Periodo getPeriodo() {
		return periodo;
	}


	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}


	@Override
	public String toString() {
		return curso.getId()+" - "+nome;
	}

}
