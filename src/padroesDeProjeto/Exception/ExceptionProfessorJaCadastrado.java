package padroesDeProjeto.Exception;

public class ExceptionProfessorJaCadastrado extends H2Exception{

	public ExceptionProfessorJaCadastrado() {
		super("Professor já cadastrado(a)");
	}

}
