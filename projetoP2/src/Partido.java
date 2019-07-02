/**
 * Classe que representa um partido politico
 *
 * @author Jessé Monteiro
 *
 */
public class Partido implements Comparable<Partido> {

	/**
	 * String que representa o nome do partido
	 */
	private String partido;
	
	/**
	 * Construtor de Partido
	 * @param partido		nome do partido
	 */
	public Partido(String partido) {
		this.partido = partido;
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
		result = prime * result + ((partido == null) ? 0 : partido.hashCode());
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
		Partido other = (Partido) obj;
		if (partido == null) {
			if (other.partido != null)
				return false;
		} else if (!partido.equals(other.partido))
			return false;
		return true;
	}


	@Override
	public int compareTo(Partido partido) {
		return this.partido.compareTo(partido.getPartido());
	
	}

}
