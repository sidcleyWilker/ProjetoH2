package padroesDeProjeto.Alocacao;

import padroesDeProjeto.modelo.Turma;

public class Alocacao {

	private Turma turma;
	private String diaSemana;
	private int horaInicil;
	private int horaFim;
	
	public Alocacao(Turma turma, String diaSemana, int horaInicil, int horaFim) {
		this.turma = turma;
		this.diaSemana = diaSemana;
		this.horaInicil = horaInicil;
		this.horaFim = horaFim;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public int getHoraInicil() {
		return horaInicil;
	}
	public void setHoraInicil(int horaInicil) {
		this.horaInicil = horaInicil;
	}
	public int getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}
	
	@Override
	public String toString(){
		return "id turma: "+getTurma().getId()+"-"+diaSemana+"-"+horaInicil+"-"+horaFim;
	}
}
