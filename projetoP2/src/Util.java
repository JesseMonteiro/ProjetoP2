import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe com métodos úteis genericos para uso no projeto
 *
 * @author Jesse Monteiro
 */
public class Util {

	/**
	 * Valida se o campo é nulo ou vazio
	 *
	 * @param campo campo a ser validado
	 * @param msg mensagem de exceção
	 * @throws Exception
	 */
	public static void validaCampo(String campo, String msg)  throws Exception {
		if (campo == null || campo.trim().isEmpty()) {
			throw new Exception(msg);
		}
	}

	/**
	 * Validador de DNI
	 *
	 * @param dni dni
	 * @param msg mensagem de exceção
	 * @throws Exception
	 */
	public static void validaDNI(String dni, String msg) throws Exception {
		if (!dni.matches("[0-9]{9}-[0-9]{1}")) {
			throw new Exception(msg);
		}
	}

	/**
	 * Valida se uma pessoa possui partido
	 *
	 * @param pessoa pessoa a ser validada
	 * @throws Exception
	 */
	public static void validaPartido(Pessoa pessoa) throws Exception {
		if(pessoa.getPartido() == null || pessoa.getPartido().equals("") ) {
			throw new Exception("Erro ao cadastrar deputado: pessoa sem partido");
		}
	}

	/**
	 * Valida se a data de inicio é válida
	 *
	 * @param dataDeInicio data de inicio do mandato
	 * @return LocalDate
	 * @throws Exception
	 */
	public static LocalDate validaDataDeInicio(String dataDeInicio) throws Exception {
		if (dataDeInicio == null || dataDeInicio.trim().isEmpty() || dataDeInicio.length() != 8) {
			throw new Exception("Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
		}
		String data = "";
		String ano = dataDeInicio.substring(4, 8);
		String mes = dataDeInicio.substring(2, 4);
		String dia = dataDeInicio.substring(0, 2);

		data = ano  + "-" + mes  + "-" + dia;

		if (!data.trim().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
			throw new Exception("Erro ao cadastrar deputado: data invalida");
		}

		if (dia.equals("29") && mes.equals("02")) {
			if (!anoBissexto(Integer.parseInt(ano))) {
				throw  new Exception("Erro ao cadastrar deputado: data invalida");
			}
		}

		LocalDate dataFiltrada = LocalDate.parse(data); //yyyy-mm-dd
		LocalDate dataAtual = LocalDate.now();

		if (dataFiltrada.compareTo(dataAtual) > 0) {
			throw new Exception("Erro ao cadastrar deputado: data futura");
		}

		try {
			return dataFiltrada;
		} catch (Exception e) {
			throw new Exception("Data de inicio invalida");
		}

	}

	/**
	 * Formata a data no formato brasileiro
	 *
	 * @param data data a ser formatada
	 * @return data formatada
	 */
	public static String dataFormatada(LocalDate data) {
		DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data.format(formatadorBarra);
	}

	/**
	 * Verifica se o ano é bissexto
	 *
	 * @param ano ano a ser verificado
	 * @return
	 */
	public static boolean anoBissexto(int ano){

		// se o ano for maior que 400
		if(ano % 400 == 0){
			return true;
			// se o ano for menor que 400
		} else if((ano % 4 == 0) && (ano % 100 != 0)){
			return true;
		} else{
			return false;
		}
	}

	/**
	 * Retorna a listagem dos artifos foramtada
	 *
	 * @param artigos artigos a serem formatados
	 * @return String representando os artigos formatados
	 */
	public static String formataArtigos(String artigos) {
		String[] aux = artigos.split(",");
		String retorno = "";
		int i = 1;
		for (String artigo: aux) {
			retorno+= artigo;
			if (i < aux.length) {
				retorno += ", ";
			}
			i++;
		}

		return retorno;
	}

}
