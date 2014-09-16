package padroesDeProjeto.Fachada;

import padroesDeProjeto.Exception.H2Exception;

/**
 * Esta interface representa as funcionalidades do sistema H2. O H2 � um sistema
 * que deve auxiliar os coordenadores no processo de aloca��o de hor�rios e est�
 * sendo desenvolvido pelos alunos do curso de ADS na disciplina de Padr�es de
 * Projetos, sob orienta��o da profa. Mirna Maia
 * 
 * @author Mirna Maia
 */
public interface FachadaIF {

	/**
	 * Esse m�todo adiciona um professor no sistema. O usu�rio deve passar como
	 * par�metro o nome e o identificador do professor. Ambos os atributos n�o
	 * podem ser vazios ou "". Caso isso aconte�a, deve ser lan�ada a exception
	 * H2Exception com a mensagem de erro "Atributo inv�lido." Caso seja
	 * inserido um professor com identificador j� cadastrado no sistema, deve
	 * ser lan�ada a exce��o H2Exception com a mensagem
	 * "Professor j� cadastrado."
	 * 
	 * @param idProfessor
	 *            O identificador do professor
	 * @param nome
	 *            O nome do professor
	 * @throws H2Exception
	 *             Caso seja inserido um professor com nome ou matr�cula vazio
	 *             ou nulo. Caso seja inserido um professor j� cadastrado.
	 */
	public void addProfessor(String idProfessor, String nome)
			throws H2Exception;

	/**
	 * Esse m�todo altera o nome do professor cujo identificador foi passado
	 * como par�metro.
	 * 
	 * @param idProfessor
	 *            O identificador do professor
	 * @param novoNome
	 *            O novo valor do nome
	 * @exception Caso
	 *                seja inserido um novoNome nulo ou vazio.
	 */
	public void alteraProfessor(String idProfessor, String novoNome)
			throws H2Exception;

	/**
	 * M�todo que remove do sistema o professor cujo identificador foi passado
	 * como par�metro. Caso o Professor n�o seja encontrado, deve ser lan�ada a
	 * exce��o H2Exception com a mensagem de erro "Professor n�o encontrado"
	 * 
	 * @param idProfessor
	 *            O identificador do professor
	 * @throws H2Exception
	 *             Caso seja digitado uma matr�cula de um professor n�o
	 *             cadastrado no sistema, deve ser lan�ada a exce��o H2Exception
	 *             com a mensagem de erro "Professor n�o encontrado"
	 */
	public void removeProfessor(String matricula) throws H2Exception;

	/**
	 * M�todo que retorna o Professor em formato String
	 * 
	 * @param identificador
	 *            O identificador do professor
	 * @return Uma String contendo o identificador do Professor - Nome. Exemplo:
	 *         00034234 - Mirna Maia
	 * @throws H2Exception
	 *             Caso o campo identificador seja nulo ou vazio deve ser
	 *             apresentada a mensagem "Atributo inv�lido". Caso n�o seja
	 *             encontrado um professor com a matr�cula passada como
	 *             par�metro, deve ser apresentada a mensagem
	 *             "Professor n�o cadastrado."
	 */
	public String getProfessor(String identificador) throws H2Exception;

	/**
	 * M�todo para criar uma disciplina. Uma disciplina deve ser criada e
	 * associado ao per�odo de um curso.
	 * 
	 * @param identificadorDisciplina
	 *            O c�digo que vai identificadr uma disciplina
	 * @param nomeDaDisciplina
	 *            O nome da disciplina que ser� adicionada.
	 * @param cargaHoraria
	 *            carga hor�ria da disciplina.
	 * @param identitficadorCurso
	 *            O c�digo identificadodr do curso previamente cadastrado no
	 *            sistema.
	 * @param identificadorperiodo
	 *            O per�odo onde essa disciplina deve ser cadastrada
	 * @throws H2Exception
	 *             Caso identificadorDisciplina, identificadorCurso sejam vazios
	 *             ou nulos deve ser lan�ada a H2Exception com a mensagem
	 *             "Atributo inv�lido"
	 */
	public void addDisciplinaAoPeriodo(String identificadorDisciplina,
			String nomeDisciplina, int cargaHoraria, String identificadorCurso,
			String identificadorperiodo) throws H2Exception;

	/**
	 * M�todo que altera o valor do atributo de uma disciplina. O campo atributo
	 * pode receber os valores "CargaHoraria" para representar a carga hor�ria
	 * da disciplina ou "Nome" para reprsentar o seu campo Nome.
	 * 
	 * @param idCurso
	 *            O identificador do Curso da disciplina que deve ser alterada
	 * @param idDisciplina
	 *            O c�digo que identifica a disciplina
	 * @param atributo
	 *            O nome do atributo que se deseja alterar.
	 * @param novoValor
	 *            O novo valor do atributo
	 * @throws H2Exception
	 *             Caso algum dos par�metros seja vazio ou nulo deve ser lan�ada
	 *             uma exce��o com a mensagem "Atributo inv�lido".
	 */
	public void alteraDisciplina(String idCurso, String sigla, String atributo,
			String novoValor) throws H2Exception;

	/**
	 * M�todo que remove a disciplina do curso e a apaga do sistema.
	 * 
	 * @param idCurso
	 *            O identificador do curso
	 * @param idDisciplina
	 *            O identificador da disciplina
	 * @throws H2Exception
	 *             Caso algum dos par�metros seja vazio ou nulo deve ser
	 *             apresentada a mensagem de erro "Atributo inv�lido". Caso a
	 *             disciplina n�o seja encontrada deve ser apresentada a
	 *             mensagem "Disciplina n�o encontrada".
	 */
	public void removeDisciplina(String idCurso, String idDisciplina)
			throws H2Exception;

	/**
	 * Retorna a disciplina em formato String.
	 * 
	 * @param idCurso
	 *            O identificador do Curso ao qual a disciplina pertence
	 * @param idDisciplina
	 *            O identificador da Disciplina
	 * @return A disciplina em formato de string. Por exemplo: <i>PP - Padr�es
	 *         de Projeto</i>
	 * @throws H2Exception
	 *             Caso o algum campo seja nulo ou vazio deve ser apresentada a
	 *             mensagem "Atributo inv�lido"
	 */
	public String getDisciplina(String idCurso, String idDisciplina)
			throws H2Exception;

	/**
	 * Metodo que adciona uma sala ao sistema.
	 * 
	 * @param idSala
	 *            O C�digo identificador da Sala.
	 * @param bloco
	 *            O Bloco onde a sala est� localizada.
	 * @throws H2Exception
	 *             Caso os campos sejam nulos ou vazios, deve ser lan�ada com a
	 *             mensagem "Atributo inv�lido". Caso j� exista uma sala com o
	 *             idSala, deve ser lan�ada uma exce��o com a mensagem
	 *             "Sala j� cadastrada".
	 */
	public void addSala(String idSala, String bloco) throws H2Exception;

	/**
	 * Metodo que altera uma sala.
	 * 
	 * @param idSala
	 *            O c�digo identificador da Sala.
	 * @param novoBloco
	 *            Novo valor do bloco da sala
	 * @throws H2Exception
	 *             Caso idSala ou novoValor sejam vazios ou nulos deve ser
	 *             lan�ada a H2Exception com a mensagem "Atributo inv�lido".
	 *             Caso n�o haja sala com idSala cadastrado no sistema, deve ser
	 *             lan�ada a exce��o "Sala n�o cadastrada"
	 * 
	 */
	public void alteraSala(String idSala, String novoBloco) throws H2Exception;

	/**
	 * Metodo que remove uma sala do sistema.
	 * 
	 * @param idSala
	 *            O identificador da Sala
	 * @throws H2Exception
	 *             Caso algum dos par�metros seja vazio ou nulo deve ser
	 *             apresentada a mensagem de erro "Atributo inv�lido." Caso
	 *             tente alterar uma sala n�o cadastrada deve ser lan�ada com a
	 *             mensagem "Sala n�o cadastrada".
	 */
	public void removeSala(String idSala) throws H2Exception;

	/**
	 * M�todo que adiciona um per�odo ao sistema. O per�odo representa um grupo
	 * de alunos de um curso que ingressaram no curso no mesmo semestre. Por
	 * exemplo,
	 * 
	 * Identificador: 2014.1 idCurso: ADS
	 * 
	 * @param identificadorPeriodo
	 *            O c�digo que identifica um per�odo
	 * @param idCurso
	 *            O c�digo que identifica o curso
	 * @throws H2Exception
	 *             Caso o identificadorPeriodo seja vazio ou nulo, deve ser
	 *             lan�ada a exce��o H2Exception com a mensagem
	 *             "Atributo inv�lido". Caso j� exista um per�odo com
	 *             identificadorPeriodo cadastrado no curso, deve ser lan�ada a
	 *             exce��o "Per�odo j� cadastrado"
	 * 
	 * 
	 */
	public void addPeriodo(String identificadorPeriodo, String idCurso)
			throws H2Exception;

	/**
	 * M�todo que remove um per�odo.
	 * 
	 * @param idCurso
	 *            O identificador do curso
	 * @param idPeriodo
	 *            O identificador do per�odo que ser� removido
	 * @throws H2Exception
	 *             Caso algum dos par�metros seja nulo ou vazio deve ser lan�ada
	 *             H2Exception com a mensagem "Atributo inv�lido". Caso o
	 *             periodo nao seja encontrado, deve ser lan�ada uma exce��o com
	 *             a mensagem "Periodo n�o cadastrado"
	 */
	public void removePeriodo(String idCurso, String nomePeriodo)
			throws H2Exception;

	/**
	 * M�todo que adiciona uma turma ao sistema. Para isso, � necess�rio que os
	 * demais recursos j� estejam cadastrados no sistema.
	 * 
	 * @param idTurma
	 *            O identificador da Turma
	 * 
	 * @param identificadorProfessor
	 *            O c�digo que identifica o Professor
	 * @param identificadorDisciplina
	 *            O c�digo da disciplina
	 * @param identificadorSala
	 *            O identificador da sala
	 * @param identificadorPeriodo
	 *            O identificador do per�odo da turma
	 * @param periodoAtual
	 * 			  O perido que a turma esta cursando
	 * @throws H2Exception
	 *             Caso algum par�metro seja nulo ou vazio deve ser lan�ada a
	 *             exce��o H2Exception com a mensagem "Atributo inv�lido"
	 */
	public void addTurma(String idTurma, String idCurso,
			String identificadorProfessor, String identificadorDisciplina,
			String identificadorSala, String identificadorPeriodo,int periodoAtual)
			throws H2Exception;

	/**
	 * M�todo que altera um dos elementos da turma.
	 * 
	 * @param identificadorTurma
	 *            O c�digo que identifica a turma
	 * @param campo
	 *            O campo que representa o nome do elemento da turma que ser�
	 *            alterado. Esse atributo pode receber os seguintes valores:
	 *            "Nome", "Professor", "Disciplina", "Sala" e "Periodo".
	 * @param novoValor
	 *            O novo valor representa o identificador do novo elemento da
	 *            turma.
	 * @throws H2Exception
	 *             Caso algum dos valores seja nulo ou vazio, ou o campo
	 *             <i>atributo</i> ser diferente dos pre-definidos deve ser
	 *             apresentada a mensagem "Atributo inv�lido."
	 * 
	 */
	public void alteraTurma(String idTurma, String campo, String novoValor)
			throws H2Exception;

	/**
	 * Remove do sistema a turma cujo identificador foi passado como par�metro.
	 * Os elementos que a comp�em N�O DEVEM SER REMOVIDOS!
	 * 
	 * @param idTurma
	 *            O identificador da turma
	 * @throws H2Exception
	 *             Caso a turma n�o tenha sido encontrada, H2Exception lan�ar�
	 *             uma exce��o com a mensagem "Turma n�o encontrada". Se este
	 *             valor for nulo ou vazio, lan�ar� a exce��o com a mensagem
	 *             "Atributo inv�lido".
	 */

	public void removerTurma(String idTurma) throws H2Exception;

	/**
	 * Esse m�todo deve retornar as informa��es da turma cujo id foi passado
	 * como par�metro. O retorno deve apresentar os seus recursos separados por
	 * v�rgulas. Por exemplo: <i>(tP1, ADS, Jos�, Prog1, 2013.1, S10)</i>.
	 * 
	 * @param idTurma
	 *            ID da turma.
	 * @return (idTurma, idCurso, idProfessor, idDisciplina, idPeriodo, idSala)
	 * @throws H2Exception
	 *             Caso o <i>idTurma</i> seja nulo ou vazio, uma exce��o ser�
	 *             lan�ada com a mensagem "Atributo inv�lido". Se nenhuma turma
	 *             for encontrada de acordo com este ID passado como par�metro,
	 *             uma exce��o com a mensagem "Turma n�o cadastrada" ser�
	 *             lan�ada.
	 */
	public String getTurma(String idTurma) throws H2Exception;

	/**
	 * Respons�vel por adicionar um curso ao sistema.
	 * 
	 * @param identificadorCurso
	 *            O c�digo que identifica o curso
	 * @param nome
	 *            O nome do Curso
	 */
	public void addCurso(String identificadorCurso, String nome)
			throws H2Exception;

	/**
	 * M�todo que altera o nome do Curso.
	 * 
	 * @param identificador
	 *            O c�digo que identifica o Curso
	 * @param novoValor
	 *            O novo nome do Curso
	 * @throws H2Exception
	 *             Caso o curso cujo c�digo passado como par�metro n�o for
	 *             encontrado no sistema, deve ser lan�ada a Exce��o com a
	 *             mensagem "Curso n�o cadastrado". Caso o novo nome do curso
	 *             seja vazio ("") ou nulo, deve ser lan�ada uma exce��o com a
	 *             mensagem "Atributo inv�lido".
	 */
	public void alterarCurso(String identificador, String novoValor)
			throws H2Exception;

	/**
	 * M�todo que remove um curso a partir de seu identificador. As turmas,
	 * per�odo e disciplinas que pertencem ao curso devem ser removidos em
	 * cascata! Caso o Curso n�o seja encontrado, deve ser lan�ada a exce��o com
	 * a mensagem de erro "Curso n�o encontrado".
	 * 
	 * @param identificador
	 *            O c�digo que identifica o curso.
	 * @throws H2Exception
	 *             Caso o curso n�o esteja cadastrado no sistema, deve ser
	 *             lan�ada a exce��o H2Exception com a mensagem
	 *             "Curso n�o encontrado"
	 */
	public void removeCurso(String identificador) throws H2Exception;

	/**
	 * Este m�todo deve retornar as informa��es do curso.
	 * 
	 * @param idCurso
	 *            O identificador do curso
	 * @return idCurso - nomeCurso
	 * @throws H2Exception
	 *             Caso o <i>idCurso</i> seja nulo ou vazio, uma exce��o ser�
	 *             lan�ada com a mensagem "Atributo inv�lido". Se o curso n�o
	 *             for encontrado no sistema, a exce��o ser� lan�ada com a
	 *             mensagem "Curso n�o cadastrado".
	 */
	public String getCurso(String idCurso) throws H2Exception;

	/**
	 * Este m�todo retorna as informa��es da Sala.
	 * 
	 * @param idSala
	 *            O c�digo que identifica a sala
	 * @throws H2Exception
	 *             Caso o <i>idSala</i> seja nulo ou vazio, uma exce��o ser�
	 *             lan�ada com a mensagem "Atributo inv�lido". Se a sala n�o for
	 *             encontrada no sistema, deve ser lan�ada uma exce��o com a
	 *             mensagem "Sala n�o cadastrada"
	 */
	public String getSala(String idSala) throws H2Exception;

	/**
	 * Este m�todo retorna as informa��es do per�odo.
	 * 
	 * @param idPeriodo
	 *            O c�digo que identifica o per�odo
	 * @param idCurso O c�digo que identifica o curso
	 * @throws H2Exception
	 *             Caso o <i>idPeriodo</i> seja nulo ou vazio, uma exce��o ser�
	 *             lan�ada com a mensagem "Atributo inv�lido".
	 */
	public String getPeriodo(String idPeriodo, String idCurso) throws H2Exception;

	/**
	 * Define o hor�rio da aula da turma (e de seus recursos). Um hor�rio �
	 * formado pelo dia da semana, hora de in�cio e hora de fim da aula. N�O h�
	 * op��o de hora fracionada!
	 * 
	 * @param idTurma
	 *            O c�digo que identifica a turma
	 * @param diaDaSemana
	 *            O dia da semana onde ser� alocada a turma
	 * @param horaInicio
	 *            A hora que inicia a aula da turma
	 * @param horaFim
	 *            A hora que termina a aula da turma
	 * @return Retorna "ok" caso n�o haja nenhum dos recursos da turma j�
	 *         cadastrado naquele hor�rio ou "Choque com <i>idRecurso</i>". Onde
	 *         idRecurso � o c�digo que identifica o recurso que j� estava
	 *         alocado nesse mesmo hor�rio em outra turma. Se houver mais de um
	 *         recurso dando choque, o resultado deve ser Choque com
	 *         <i>idRecurso1, idRecurso2</i>
	 * @throws H2Exception
	 *             Caso os par�metros sejam nulos ou vazios, deve ser lan�ada
	 *             uma H2Exception com a mensagem "Atributo inv�lido".
	 */
	public String alocaTurmaAoHorario(String idTurma, String diaDaSemana,
			int horaInicio, int horafim) throws H2Exception;

	/**
	 * Remove a turma (e seus recursos) do hor�rio passado como par�metro. N�O
	 * h� op��o de hora fracionada!
	 * 
	 * @param idTurma
	 *            O c�digo que identifica a turma
	 * @oaram diaDaSemana O dia da semana da aula
	 * @param horaInicio
	 *            A hora que inicia a aula
	 * @param horaFim
	 *            A hora que termina a aula
	 * @return Retorna "ok" caso n�o haja nenhum dos recursos da turma j�
	 *         cadastrado naquele hor�rio ou "Choque com <i>idRecurso</i>". Onde
	 *         idRecurso � o c�digo que identifica o recurso que j� estava
	 *         alocado nesse mesmo hor�rio em outra turma. Se houver mais de um
	 *         recurso dando choque, o resultado deve ser Choque com
	 *         <i>idRecurso1, idRecurso2</i>
	 * @throws H2Exception
	 *             Caso os par�metros sejam nulos ou vazios, deve ser lan�ada
	 *             uma H2Exception com a mensagem "Atributo inv�lido".
	 */
	public String desalocaTurmaDoHorario(String idTurma, String diaDaSemana,
			int horaInicio, int horaFim) throws H2Exception;

	/**
	 * M�todo que apresenta o hor�rio da turma em formato String. Caso a turma
	 * n�o esteja alocada em nenhum hor�rio, deve ser lan�ada uma exce��o com a
	 * mensagem "Turma sem hor�rio". O hor�rio deve seguir o seguinte formato:
	 * 
	 * Segunda: 10 �s 12 Ter�a: 14 �s 16 Sexta: 8 �s 10
	 * 
	 * Lembrando que n�o a op��o de hora fracionada.
	 * 
	 * @param idTurma
	 *            O c�digo que identifica a turma
	 * @return O hor�rio da turma
	 * @throws H2Exception
	 *             Caso a turma n�o tenha sido alocada ainda. Ou caso algum dos par�metros seja inv�lido.
	 */
	public String getHorario(String idTurma) throws H2Exception;

	/**
	 * M�todo que apresenta as turmas que foram alocadas no hor�rio passado como
	 * par�metro.
	 * 
	 * @param diaDaSemana
	 *            O dia da semana do hor�rio
	 * @param horaInicio
	 *            A hora que inicia a aula
	 * @param horaFim
	 *            A hora do fim da aula
	 * @return Retorna os identificadores das turmas que est�o alocadas para o
	 *         hor�rio passado como par�metro. Os identificadores devem ser
	 *         separados por v�rgula.
	 * @throws H2Exception Caso algum dos par�metros seja inv�lido.
	 */
	public String getTurmas(String diaDaSemana, int horaInicio, int horaFim)
			throws H2Exception;
	
	/**
	 * M�todo que salva o horario atual em um arquivo cujo nome foi passado como
	 * parametro. O formato do arquivo � decis�o do projetista/desenvolvedor.
	 * Caso j� exista um arquivo com mesmo nome, deve ser sobrescrito pelo novo.
	 * 
	 * @param nomeDoArquivo
	 *            O nome do arquivo onde o hor�rio deve ser salvo.
	 * @return "O arquivo <nomeDoArquivo> foi criado com sucesso." Caso o
	 *         arquivo tenha sido criado corretamente com o hor�rio. Caso
	 *         contr�rio, deve ser impressa uma mensagem de erro explicando o
	 *         motivo (n�o h� padr�o para as mensagens de erro).
	 * 
	 */
	public String salvaHorario(String nomeDoArquivo);
}