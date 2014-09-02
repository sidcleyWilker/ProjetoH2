import padroesDeProjeto.BancoDeDados.BD;
import padroesDeProjeto.BancoDeDados.IO;
import padroesDeProjeto.Exception.H2Exception;
import padroesDeProjeto.Fachada.FachadaCliente;


public class App {

	public static void main(String[] args) throws H2Exception {
		
//		BD bd = new BD();
//		IO.getInstance().save(bd);
//		
		FachadaCliente fa = new FachadaCliente();
//" addDisciplinaAoPeriodo id="" nomeDaDisciplina="Padrões de Projeto" cargaHoraria=100 nomeCurso="ADS"  sigla="ADS_PP" 
//id = "id" nome = "bd1" cargaHoraria 100 curso = "ADS" periodo="2012.1"
		fa.addCurso("ADS", "Analise e de...");
		fa.addPeriodo("2012.1", "ADS");
		fa.addDisciplinaAoPeriodo("id","bd1", 100, "ADS", "2012.1");
	}

}
