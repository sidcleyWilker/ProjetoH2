
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.Fachada.FachadaCliente;
import padroesDeProjeto.util.Util;


public class App {

	public static void main(String[] args) throws H2Exception {
		
		FachadaCliente cl = new FachadaCliente();
		//Util.bd.salvar();
		
		System.out.println(cl.alocaTurmaAoHorario("turma2", "segunda", 7, 10));
		//System.out.println(cl.getHorario("turma1"));
	}

}
