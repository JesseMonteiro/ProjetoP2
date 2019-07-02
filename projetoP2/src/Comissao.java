/**
 * Classe que representa uma comissao
 *
 * @author Jessé Monteiro
 *
 */
public class Comissao {


	/**
	 * String que representa o tema da comissao
	 */
	private String tema;

	/**
	 * String que traz os DNIs dos politicos que fazem parte da comissao
	 */
	private String politicos;


	/**
	 * Construtor de Comissao
	 *
	 * @param tema		tema da comissao
	 * @param politicos	DNIs dos politicos
	 */
	public Comissao (String tema, String politicos) {
		this.tema = tema;
		this.politicos = politicos;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getPoliticos() {
		return politicos;
	}

	public void setPoliticos(String politicos) {
		this.politicos = politicos;
	}

}
