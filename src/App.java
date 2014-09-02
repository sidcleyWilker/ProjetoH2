import padroesDeProjeto.BancoDeDados.BD;
import padroesDeProjeto.BancoDeDados.IO;
import padroesDeProjeto.Exception.H2Exception;


public class App {

	public static void main(String[] args) throws H2Exception {
		
		BD bd = new BD();
		IO.getInstance().save(bd);
		
	}

}
