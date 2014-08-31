import padroesDeProjeto.BancoDeDados.BD;
import padroesDeProjeto.BancoDeDados.IO;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.Fachada.FachadaCliente;


public class App {

	public static void main(String[] args) throws H2Exception {
		
//		BD bd = new BD();
//		
//		IO.getInstance().save(bd);
		
		FachadaCliente fachada = new FachadaCliente();
		
		
		//fachada.addProfessor("123", "sasuke");
		System.out.println(fachada.getProfessor("123"));
	}

}
