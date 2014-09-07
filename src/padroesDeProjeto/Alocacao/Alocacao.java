package padroesDeProjeto.Alocacao;

import padroesDeProjeto.modelo.Turma;
/**
 * class vai representar a alocação de uma turma em um dia
 * da semana num determinado horario
 * @author Sidcley
 *
 */
public class Alocacao {

	private Turma turma;
	private String diaSemana;
	private int horaIni;
	private int horaFim;
	
	public Alocacao(Turma turma, String diaSemana, int horaIni, int horaFim) {
		this.turma = turma;
		this.diaSemana = diaSemana;
		this.horaIni = horaIni;
		this.horaFim = horaFim;
	}
	
	public Alocacao(){
		
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
	public int getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(int horaIni) {
		this.horaIni = horaIni;
	}
	public int getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}
	
	
	@Override
	public String toString(){
		return turma.getId()+ " - " +getDiaSemana() + " - "
				+ getHoraIni() + " ás " +getHoraFim();
	}
}
