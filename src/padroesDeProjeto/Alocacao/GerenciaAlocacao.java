package padroesDeProjeto.Alocacao;

import padroesDeProjeto.Exception.ExceptionParametroInvalido;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.util.Util;
import padroesDeProjeto.util.VerificadorDeObjetos;

public class GerenciaAlocacao {

	private VerificadorDeObjetos verificador;
	
	public GerenciaAlocacao() {
		verificador = new VerificadorDeObjetos();
	}

	public String alocaTurmaAoHorario(String idTurma, String diaDaSemana,int horaInicio, int horafim) throws Exception{
		verificadorDeAtributos(idTurma, diaDaSemana, horaInicio, horafim);
		return null;
	}


	public String desalocaTurmaDoHorario(String idTurma, String diaDaSemana,int horaInicio, int horaFim) {

		return null;
	}

	
	public String getHorario(String idTurma)  {
	
		return null;
	}
	
	public String getTurmas(String diaDaSemana, int horaInicio, int horaFim){

		return null;
	}

	private void verificadorDeAtributos(String idTurma, String diaDaSemana,int horaInicio, int horafim)
				throws H2Exception{
		Util.verificaAtributo(idTurma,diaDaSemana);
		Util.verificaAtributoCargaHoraria(horaInicio,horafim);
		if(verificador.comtemTurma(idTurma)){
			
		}else{
			throw new ExceptionParametroInvalido();
		}
	}
}
