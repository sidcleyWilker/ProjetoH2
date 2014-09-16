package padroesDeProjeto.Fachada;

import padroesDeProjeto.Exception.H2Exception;

/**
 * Esta interface representa as funcionalidades do sistema H2. O H2 é um sistema
 * que deve auxiliar os coordenadores no processo de alocação de horários e está
 * sendo desenvolvido pelos alunos do curso de ADS na disciplina de Padrões de
 * Projetos, sob orientação da profa. Mirna Maia
 * 
 * @author Mirna Maia
 */
public interface FachadaIF {

	/**
	 * Esse método adiciona um professor no sistema. O usuário deve passar como
	 * parâmetro o nome e o identificador do professor. Ambos os atributos não
	 * podem ser vazios ou "". Caso isso aconteça, deve ser lançada a exception
	 * H2Exception com a mensagem de erro "Atributo inválido." Caso seja
	 * inserido um professor com identificador já cadastrado no sistema, deve
	 * ser lançada a exceção H2Exception com a mensagem
	 * "Professor já cadastrado."
	 * 
	 * @param idProfessor
	 *            O identificador do professor
	 * @param nome
	 *            O nome do professor
	 * @throws H2Exception
	 *             Caso seja inserido um professor com nome ou matrícula vazio
	 *             ou nulo. Caso seja inserido um professor já cadastrado.
	 */
	public void addProfessor(String idProfessor, String nome)
			throws H2Exception;

	/**
	 * Esse método altera o nome do professor cujo identificador foi passado
	 * como parâmetro.
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
	 * Método que remove do sistema o professor cujo identificador foi passado
	 * como parâmetro. Caso o Professor não seja encontrado, deve ser lançada a
	 * exceção H2Exception com a mensagem de erro "Professor não encontrado"
	 * 
	 * @param idProfessor
	 *            O identificador do professor
	 * @throws H2Exception
	 *             Caso seja digitado uma matrícula de um professor não
	 *             cadastrado no sistema, deve ser lançada a exceção H2Exception
	 *             com a mensagem de erro "Professor não encontrado"
	 */
	public void removeProfessor(String matricula) throws H2Exception;

	/**
	 * Método que retorna o Professor em formato String
	 * 
	 * @param identificador
	 *            O identificador do professor
	 * @return Uma String contendo o identificador do Professor - Nome. Exemplo:
	 *         00034234 - Mirna Maia
	 * @throws H2Exception
	 *             Caso o campo identificador seja nulo ou vazio deve ser
	 *             apresentada a mensagem "Atributo inválido". Caso não seja
	 *             encontrado um professor com a matrícula passada como
	 *             parâmetro, deve ser apresentada a mensagem
	 *             "Professor não cadastrado."
	 */
	public String getProfessor(String identificador) throws H2Exception;

	/**
	 * Método para criar uma disciplina. Uma disciplina deve ser criada e
	 * associado ao período de um curso.
	 * 
	 * @param identificadorDisciplina
	 *            O código que vai identificadr uma disciplina
	 * @param nomeDaDisciplina
	 *            O nome da disciplina que será adicionada.
	 * @param cargaHoraria
	 *            carga horária da disciplina.
	 * @param identitficadorCurso
	 *            O código identificadodr do curso previamente cadastrado no
	 *            sistema.
	 * @param identificadorperiodo
	 *            O período onde essa disciplina deve ser cadastrada
	 * @throws H2Exception
	 *             Caso identificadorDisciplina, identificadorCurso sejam vazios
	 *             ou nulos deve ser lançada a H2Exception com a mensagem
	 *             "Atributo inválido"
	 */
	public void addDisciplinaAoPeriodo(String identificadorDisciplina,
			String nomeDisciplina, int cargaHoraria, String identificadorCurso,
			String identificadorperiodo) throws H2Exception;

	/**
	 * Método que altera o valor do atributo de uma disciplina. O campo atributo
	 * pode receber os valores "CargaHoraria" para representar a carga horária
	 * da disciplina ou "Nome" para reprsentar o seu campo Nome.
	 * 
	 * @param idCurso
	 *            O identificador do Curso da disciplina que deve ser alterada
	 * @param idDisciplina
	 *            O código que identifica a disciplina
	 * @param atributo
	 *            O nome do atributo que se deseja alterar.
	 * @param novoValor
	 *            O novo valor do atributo
	 * @throws H2Exception
	 *             Caso algum dos parâmetros seja vazio ou nulo deve ser lançada
	 *             uma exceção com a mensagem "Atributo inválido".
	 */
	public void alteraDisciplina(String idCurso, String sigla, String atributo,
			String novoValor) throws H2Exception;

	/**
	 * Método que remove a disciplina do curso e a apaga do sistema.
	 * 
	 * @param idCurso
	 *            O identificador do curso
	 * @param idDisciplina
	 *            O identificador da disciplina
	 * @throws H2Exception
	 *             Caso algum dos parâmetros seja vazio ou nulo deve ser
	 *             apresentada a mensagem de erro "Atributo inválido". Caso a
	 *             disciplina não seja encontrada deve ser apresentada a
	 *             mensagem "Disciplina não encontrada".
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
	 * @return A disciplina em formato de string. Por exemplo: <i>PP - Padrões
	 *         de Projeto</i>
	 * @throws H2Exception
	 *             Caso o algum campo seja nulo ou vazio deve ser apresentada a
	 *             mensagem "Atributo inválido"
	 */
	public String getDisciplina(String idCurso, String idDisciplina)
			throws H2Exception;

	/**
	 * Metodo que adciona uma sala ao sistema.
	 * 
	 * @param idSala
	 *            O Código identificador da Sala.
	 * @param bloco
	 *            O Bloco onde a sala está localizada.
	 * @throws H2Exception
	 *             Caso os campos sejam nulos ou vazios, deve ser lançada com a
	 *             mensagem "Atributo inválido". Caso já exista uma sala com o
	 *             idSala, deve ser lançada uma exceção com a mensagem
	 *             "Sala já cadastrada".
	 */
	public void addSala(String idSala, String bloco) throws H2Exception;

	/**
	 * Metodo que altera uma sala.
	 * 
	 * @param idSala
	 *            O código identificador da Sala.
	 * @param novoBloco
	 *            Novo valor do bloco da sala
	 * @throws H2Exception
	 *             Caso idSala ou novoValor sejam vazios ou nulos deve ser
	 *             lançada a H2Exception com a mensagem "Atributo inválido".
	 *             Caso não haja sala com idSala cadastrado no sistema, deve ser
	 *             lançada a exceção "Sala não cadastrada"
	 * 
	 */
	public void alteraSala(String idSala, String novoBloco) throws H2Exception;

	/**
	 * Metodo que remove uma sala do sistema.
	 * 
	 * @param idSala
	 *            O identificador da Sala
	 * @throws H2Exception
	 *             Caso algum dos parâmetros seja vazio ou nulo deve ser
	 *             apresentada a mensagem de erro "Atributo inválido." Caso
	 *             tente alterar uma sala não cadastrada deve ser lançada com a
	 *             mensagem "Sala não cadastrada".
	 */
	public void removeSala(String idSala) throws H2Exception;

	/**
	 * Método que adiciona um período ao sistema. O período representa um grupo
	 * de alunos de um curso que ingressaram no curso no mesmo semestre. Por
	 * exemplo,
	 * 
	 * Identificador: 2014.1 idCurso: ADS
	 * 
	 * @param identificadorPeriodo
	 *            O código que identifica um período
	 * @param idCurso
	 *            O código que identifica o curso
	 * @throws H2Exception
	 *             Caso o identificadorPeriodo seja vazio ou nulo, deve ser
	 *             lançada a exceção H2Exception com a mensagem
	 *             "Atributo inválido". Caso já exista um período com
	 *             identificadorPeriodo cadastrado no curso, deve ser lançada a
	 *             exceção "Período já cadastrado"
	 * 
	 * 
	 */
	public void addPeriodo(String identificadorPeriodo, String idCurso)
			throws H2Exception;

	/**
	 * Método que remove um período.
	 * 
	 * @param idCurso
	 *            O identificador do curso
	 * @param idPeriodo
	 *            O identificador do período que será removido
	 * @throws H2Exception
	 *             Caso algum dos parâmetros seja nulo ou vazio deve ser lançada
	 *             H2Exception com a mensagem "Atributo inválido". Caso o
	 *             periodo nao seja encontrado, deve ser lançada uma exceção com
	 *             a mensagem "Periodo não cadastrado"
	 */
	public void removePeriodo(String idCurso, String nomePeriodo)
			throws H2Exception;

	/**
	 * Método que adiciona uma turma ao sistema. Para isso, é necessário que os
	 * demais recursos já estejam cadastrados no sistema.
	 * 
	 * @param idTurma
	 *            O identificador da Turma
	 * 
	 * @param identificadorProfessor
	 *            O código que identifica o Professor
	 * @param identificadorDisciplina
	 *            O código da disciplina
	 * @param identificadorSala
	 *            O identificador da sala
	 * @param identificadorPeriodo
	 *            O identificador do período da turma
	 * @param periodoAtual
	 * 			  O perido que a turma esta cursando
	 * @throws H2Exception
	 *             Caso algum parâmetro seja nulo ou vazio deve ser lançada a
	 *             exceção H2Exception com a mensagem "Atributo inválido"
	 */
	public void addTurma(String idTurma, String idCurso,
			String identificadorProfessor, String identificadorDisciplina,
			String identificadorSala, String identificadorPeriodo,int periodoAtual)
			throws H2Exception;

	/**
	 * Método que altera um dos elementos da turma.
	 * 
	 * @param identificadorTurma
	 *            O código que identifica a turma
	 * @param campo
	 *            O campo que representa o nome do elemento da turma que será
	 *            alterado. Esse atributo pode receber os seguintes valores:
	 *            "Nome", "Professor", "Disciplina", "Sala" e "Periodo".
	 * @param novoValor
	 *            O novo valor representa o identificador do novo elemento da
	 *            turma.
	 * @throws H2Exception
	 *             Caso algum dos valores seja nulo ou vazio, ou o campo
	 *             <i>atributo</i> ser diferente dos pre-definidos deve ser
	 *             apresentada a mensagem "Atributo inválido."
	 * 
	 */
	public void alteraTurma(String idTurma, String campo, String novoValor)
			throws H2Exception;

	/**
	 * Remove do sistema a turma cujo identificador foi passado como parâmetro.
	 * Os elementos que a compõem NÃO DEVEM SER REMOVIDOS!
	 * 
	 * @param idTurma
	 *            O identificador da turma
	 * @throws H2Exception
	 *             Caso a turma não tenha sido encontrada, H2Exception lançará
	 *             uma exceção com a mensagem "Turma não encontrada". Se este
	 *             valor for nulo ou vazio, lançará a exceção com a mensagem
	 *             "Atributo inválido".
	 */

	public void removerTurma(String idTurma) throws H2Exception;

	/**
	 * Esse método deve retornar as informações da turma cujo id foi passado
	 * como parâmetro. O retorno deve apresentar os seus recursos separados por
	 * vírgulas. Por exemplo: <i>(tP1, ADS, José, Prog1, 2013.1, S10)</i>.
	 * 
	 * @param idTurma
	 *            ID da turma.
	 * @return (idTurma, idCurso, idProfessor, idDisciplina, idPeriodo, idSala)
	 * @throws H2Exception
	 *             Caso o <i>idTurma</i> seja nulo ou vazio, uma exceção será
	 *             lançada com a mensagem "Atributo inválido". Se nenhuma turma
	 *             for encontrada de acordo com este ID passado como parâmetro,
	 *             uma exceção com a mensagem "Turma não cadastrada" será
	 *             lançada.
	 */
	public String getTurma(String idTurma) throws H2Exception;

	/**
	 * Responsável por adicionar um curso ao sistema.
	 * 
	 * @param identificadorCurso
	 *            O código que identifica o curso
	 * @param nome
	 *            O nome do Curso
	 */
	public void addCurso(String identificadorCurso, String nome)
			throws H2Exception;

	/**
	 * Método que altera o nome do Curso.
	 * 
	 * @param identificador
	 *            O código que identifica o Curso
	 * @param novoValor
	 *            O novo nome do Curso
	 * @throws H2Exception
	 *             Caso o curso cujo código passado como parâmetro não for
	 *             encontrado no sistema, deve ser lançada a Exceção com a
	 *             mensagem "Curso não cadastrado". Caso o novo nome do curso
	 *             seja vazio ("") ou nulo, deve ser lançada uma exceção com a
	 *             mensagem "Atributo inválido".
	 */
	public void alterarCurso(String identificador, String novoValor)
			throws H2Exception;

	/**
	 * Método que remove um curso a partir de seu identificador. As turmas,
	 * período e disciplinas que pertencem ao curso devem ser removidos em
	 * cascata! Caso o Curso não seja encontrado, deve ser lançada a exceção com
	 * a mensagem de erro "Curso não encontrado".
	 * 
	 * @param identificador
	 *            O código que identifica o curso.
	 * @throws H2Exception
	 *             Caso o curso não esteja cadastrado no sistema, deve ser
	 *             lançada a exceção H2Exception com a mensagem
	 *             "Curso não encontrado"
	 */
	public void removeCurso(String identificador) throws H2Exception;

	/**
	 * Este método deve retornar as informações do curso.
	 * 
	 * @param idCurso
	 *            O identificador do curso
	 * @return idCurso - nomeCurso
	 * @throws H2Exception
	 *             Caso o <i>idCurso</i> seja nulo ou vazio, uma exceção será
	 *             lançada com a mensagem "Atributo inválido". Se o curso não
	 *             for encontrado no sistema, a exceção será lançada com a
	 *             mensagem "Curso não cadastrado".
	 */
	public String getCurso(String idCurso) throws H2Exception;

	/**
	 * Este método retorna as informações da Sala.
	 * 
	 * @param idSala
	 *            O código que identifica a sala
	 * @throws H2Exception
	 *             Caso o <i>idSala</i> seja nulo ou vazio, uma exceção será
	 *             lançada com a mensagem "Atributo inválido". Se a sala não for
	 *             encontrada no sistema, deve ser lançada uma exceção com a
	 *             mensagem "Sala não cadastrada"
	 */
	public String getSala(String idSala) throws H2Exception;

	/**
	 * Este método retorna as informações do período.
	 * 
	 * @param idPeriodo
	 *            O código que identifica o período
	 * @param idCurso O código que identifica o curso
	 * @throws H2Exception
	 *             Caso o <i>idPeriodo</i> seja nulo ou vazio, uma exceção será
	 *             lançada com a mensagem "Atributo inválido".
	 */
	public String getPeriodo(String idPeriodo, String idCurso) throws H2Exception;

	/**
	 * Define o horário da aula da turma (e de seus recursos). Um horário é
	 * formado pelo dia da semana, hora de início e hora de fim da aula. NÃO há
	 * opção de hora fracionada!
	 * 
	 * @param idTurma
	 *            O código que identifica a turma
	 * @param diaDaSemana
	 *            O dia da semana onde será alocada a turma
	 * @param horaInicio
	 *            A hora que inicia a aula da turma
	 * @param horaFim
	 *            A hora que termina a aula da turma
	 * @return Retorna "ok" caso não haja nenhum dos recursos da turma já
	 *         cadastrado naquele horário ou "Choque com <i>idRecurso</i>". Onde
	 *         idRecurso é o código que identifica o recurso que já estava
	 *         alocado nesse mesmo horário em outra turma. Se houver mais de um
	 *         recurso dando choque, o resultado deve ser Choque com
	 *         <i>idRecurso1, idRecurso2</i>
	 * @throws H2Exception
	 *             Caso os parâmetros sejam nulos ou vazios, deve ser lançada
	 *             uma H2Exception com a mensagem "Atributo inválido".
	 */
	public String alocaTurmaAoHorario(String idTurma, String diaDaSemana,
			int horaInicio, int horafim) throws H2Exception;

	/**
	 * Remove a turma (e seus recursos) do horário passado como parâmetro. NÃO
	 * há opção de hora fracionada!
	 * 
	 * @param idTurma
	 *            O código que identifica a turma
	 * @oaram diaDaSemana O dia da semana da aula
	 * @param horaInicio
	 *            A hora que inicia a aula
	 * @param horaFim
	 *            A hora que termina a aula
	 * @return Retorna "ok" caso não haja nenhum dos recursos da turma já
	 *         cadastrado naquele horário ou "Choque com <i>idRecurso</i>". Onde
	 *         idRecurso é o código que identifica o recurso que já estava
	 *         alocado nesse mesmo horário em outra turma. Se houver mais de um
	 *         recurso dando choque, o resultado deve ser Choque com
	 *         <i>idRecurso1, idRecurso2</i>
	 * @throws H2Exception
	 *             Caso os parâmetros sejam nulos ou vazios, deve ser lançada
	 *             uma H2Exception com a mensagem "Atributo inválido".
	 */
	public String desalocaTurmaDoHorario(String idTurma, String diaDaSemana,
			int horaInicio, int horaFim) throws H2Exception;

	/**
	 * Método que apresenta o horário da turma em formato String. Caso a turma
	 * não esteja alocada em nenhum horário, deve ser lançada uma exceção com a
	 * mensagem "Turma sem horário". O horário deve seguir o seguinte formato:
	 * 
	 * Segunda: 10 às 12 Terça: 14 às 16 Sexta: 8 às 10
	 * 
	 * Lembrando que não a opção de hora fracionada.
	 * 
	 * @param idTurma
	 *            O código que identifica a turma
	 * @return O horário da turma
	 * @throws H2Exception
	 *             Caso a turma não tenha sido alocada ainda. Ou caso algum dos parâmetros seja inválido.
	 */
	public String getHorario(String idTurma) throws H2Exception;

	/**
	 * Método que apresenta as turmas que foram alocadas no horário passado como
	 * parâmetro.
	 * 
	 * @param diaDaSemana
	 *            O dia da semana do horário
	 * @param horaInicio
	 *            A hora que inicia a aula
	 * @param horaFim
	 *            A hora do fim da aula
	 * @return Retorna os identificadores das turmas que estão alocadas para o
	 *         horário passado como parâmetro. Os identificadores devem ser
	 *         separados por vírgula.
	 * @throws H2Exception Caso algum dos parâmetros seja inválido.
	 */
	public String getTurmas(String diaDaSemana, int horaInicio, int horaFim)
			throws H2Exception;
	
	/**
	 * Método que salva o horario atual em um arquivo cujo nome foi passado como
	 * parametro. O formato do arquivo é decisão do projetista/desenvolvedor.
	 * Caso já exista um arquivo com mesmo nome, deve ser sobrescrito pelo novo.
	 * 
	 * @param nomeDoArquivo
	 *            O nome do arquivo onde o horário deve ser salvo.
	 * @return "O arquivo <nomeDoArquivo> foi criado com sucesso." Caso o
	 *         arquivo tenha sido criado corretamente com o horário. Caso
	 *         contrário, deve ser impressa uma mensagem de erro explicando o
	 *         motivo (não há padrão para as mensagens de erro).
	 * 
	 */
	public String salvaHorario(String nomeDoArquivo);
}