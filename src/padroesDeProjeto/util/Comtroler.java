package padroesDeProjeto.util;

/**
 * class que da o comando para executar o command de alguma class
 * @author Sidcley
 *
 */
public class Comtroler {

	private Command commando;
	
	public Comtroler() {
	
	}
	
	public void setCommand(Command commando){
		this.commando = commando;
	}
	
	public void executarCommando(){
		commando.execut();
	}
}
