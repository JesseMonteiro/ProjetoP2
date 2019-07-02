import java.time.LocalDate;

/**
 * Classe que representa um Deputado no sistema
 *
 * @author Jesse Monteiro
 *
 */
public class Deputado extends Pessoa {

	/**
	 * Inteiro que representa a quantidade de leis aprovadas
	 */
	private int leisAprovadas;

	/**
	 * Data que representa a data de inicio do mandato do deputado
	 */
	private LocalDate dataDeInicio;

	/**
	 * Contrutor de Deputado
	 *
	 * @param nome          nome do deputado
	 * @param dni			dni do deputado
	 * @param estado		estado do deputado
	 * @param interesses	interesses do deputado
	 * @param partido		partido do deputado
	 * @param dataDeInicio	data de inicio do mandato do deputado
	 * @throws Exception	excecao lancada caso o cadastro nao esteja correto
	 */
	public Deputado(String nome, String dni, String estado, String interesses, String partido, LocalDate dataDeInicio)
			throws Exception {
		super(nome, dni, estado, interesses, partido);
		this.leisAprovadas = 0;
		this.dataDeInicio = dataDeInicio;

	}

	public int getLeisAprovadas() {
		return leisAprovadas;
	}

	public void setLeisAprovadas(int leisAprovadas) {
		this.leisAprovadas = leisAprovadas;
	}

	public LocalDate getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(LocalDate dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

}
