package padroesDeProjeto.Alocacao;

import java.util.HashMap;
import java.util.Map; 

import padroesDeProjeto.util.Util;

public class Horario {

	private Map<String,Alocacao> segunda = new HashMap<>();
	private Map<String,Alocacao> terca = new HashMap<>();
	private Map<String,Alocacao> quarta = new HashMap<>();
	private Map<String,Alocacao> quinta = new HashMap<>();
	private Map<String,Alocacao> sexta = new HashMap<>();
	
	
	public Map<String, Alocacao> getSegunda() {
		return segunda;
	}


	public void setSegunda(Map<String, Alocacao> segunda) {
		this.segunda = segunda;
	}


	public Map<String, Alocacao> getTerca() {
		return terca;
	}




	public void setTerca(Map<String, Alocacao> terca) {
		this.terca = terca;
	}




	public Map<String, Alocacao> getQuarta() {
		return quarta;
	}




	public void setQuarta(Map<String, Alocacao> quarta) {
		this.quarta = quarta;
	}




	public Map<String, Alocacao> getQuinta() {
		return quinta;
	}




	public void setQuinta(Map<String, Alocacao> quinta) {
		this.quinta = quinta;
	}




	public Map<String, Alocacao> getSexta() {
		return sexta;
	}




	public void setSexta(Map<String, Alocacao> sexta) {
		this.sexta = sexta;
	}




	public void caregarHorario(){
		setSegunda(Util.bd.getHorario().getSegunda());
		setTerca(Util.bd.getHorario().getTerca());
		setQuarta(Util.bd.getHorario().getQuarta());
		setQuinta(Util.bd.getHorario().getQuinta());
		setSexta(Util.bd.getHorario().getSexta());
	}

}
