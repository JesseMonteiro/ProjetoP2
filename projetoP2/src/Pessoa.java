/**
 * Classe que representa uma Pessoa no sistema
 * 
 * @author Jesse Monteiro
 *
 */
public class Pessoa {

	/**
	 * String que representa o nome da pessoa
	 */
	private String nome;
	/**
	 * String que representa o DNI (Documento Nacional de Identificacao) da pessoa
	 */
	private String dni;
	/**
	 * String que representa o estado da pessoa
	 */
	private String estado;
	/**
	 * String que representa o partido da pessoa
	 */
	private String partido;
	/**
	 * String que representa os interesses da pessoa
	 */
	private String interesses;

	/**
	 * Contrutor de Pessoa
	 * 
	 * @param nome       nome da pessoa
	 * @param dni        DNI (Documento Nacional de Identificacao) da pessoa
	 * @param estado     estado da pessoa
	 * @param interesses interesses da pessoa
	 * @param partido    partido da pessoa
	 * @throws Exception excecao lancada caso o cadastro nao esteja correto
	 */
	public Pessoa(String nome, String dni, String estado, String interesses, String partido) throws Exception {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.partido = partido;
		this.interesses = interesses;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getInteresses() {
		return this.interesses;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

}
