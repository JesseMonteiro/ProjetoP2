import easyaccept.EasyAccept;

import java.time.LocalDate;
import java.util.*;

/**
 * Classe Facade
 *
 * @author Jesse Monteiro
 */
public class Eco {

	/**
	 *  Representa a lista de pessoas do sistema
	 */
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	/**
	 * Representa a lista de deputados do sistema
	 */
	private List<Deputado> deputados = new ArrayList<Deputado>();
	/**
	 * Reoresenta a lista de partidos no sistema
	 */
	private List<Partido> baseGoverno = new ArrayList<Partido>();
	/**
	 * Representa a lista de comissões parlamentares no sistema
	 *
	 */
	private List<Comissao> comissoes = new ArrayList<Comissao>();
	/**
	 * Mapa de PL que ano é a chave e o ultimo indice é o valor
	 */
	private HashMap<Integer, Integer> codigosPL = new HashMap<Integer, Integer>();
	/**
	 * Mapa de PLP que ano é a chave e o ultimo indice é o valor
	 */
	private HashMap<Integer, Integer> codigosPLP = new HashMap<Integer, Integer>();
	/**
	 * Mapa de PEC que ano é a chave e o ultimo indice é o valor
	 */
	private HashMap<Integer, Integer> codigosPEC = new HashMap<Integer, Integer>();
	/**
	 * Representa a lista de projetos
	 */
	private List<Projeto> projetos = new ArrayList<Projeto>();


	/**
	 * Metodo main de chamada da facade para executar os testes.
	 * @param args
	 */
	public static void main(String[] args) {
		args = new String[]{"Eco", "easyAccept/use_case_1.txt", "easyAccept/use_case_2.txt",
				"easyAccept/use_case_3.txt", "easyAccept/use_case_4.txt", "easyAccept/use_case_5.txt",
				"easyAccept/use_case_6.txt"};
		EasyAccept.main(args);
	}


	/**
	 * Cadastra uma pessoa no sistema
	 *
	 * @param nome       nome da pessoa
	 * @param dni        DNI (Documento Nacional de Identificacao) da pessoa
	 * @param estado     estado da pessoa
	 * @param interesses interesses da pessoa
	 * @throws Exception excecao lançada caso DNI ja exista
	 */
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) throws Exception {

		Util.validaCampo(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		Util.validaCampo(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		Util.validaCampo(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		Util.validaDNI(dni, "Erro ao cadastrar pessoa: dni invalido");

		Pessoa pessoa = new Pessoa(nome, dni, estado, interesses, "");
		if (!pessoas.contains(pessoa)) {
			pessoas.add(pessoa);
		} else {
			throw new Exception("Erro ao cadastrar pessoa: dni ja cadastrado");
		}
	}

	/**
	 * Cadastra uma pessoa com partido no sistema
	 *
	 * @param nome       nome da pessoa
	 * @param dni        DNI (Documento Nacional de Identificacao) da pessoa
	 * @param estado     estado da pessoa
	 * @param interesses interesses da pessoa
	 * @param partido    partido do deputado
	 * @throws Exception excecao lançada caso DNI ja exista
	 */
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) throws
			Exception {

		Util.validaCampo(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		Util.validaCampo(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		Util.validaCampo(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		Util.validaDNI(dni, "Erro ao cadastrar pessoa: dni invalido");

		Pessoa pessoa = new Pessoa(nome, dni, estado, interesses, partido);
		if (!pessoas.contains(pessoa)) {
			pessoas.add(pessoa);
		} else {
			throw new Exception("Erro ao cadastrar pessoa: dni ja cadastrado");
		}
	}

	/**
	 * Cadastra um deputado no sistema
	 *
	 * @param dni          Numero identificador
	 * @param dataDeInicio Inicio do mandato
	 * @throws Exception
	 */
	public void cadastrarDeputado(String dni, String dataDeInicio) throws Exception {
		Util.validaCampo(dni, "Erro ao cadastrar deputado: dni nao pode ser vazio ou nulo");
		Util.validaDNI(dni, "Erro ao cadastrar deputado: dni invalido");
		Pessoa pessoa = buscaPessoa(dni);

		if (pessoa == null) {
			throw new Exception("Erro ao cadastrar deputado: pessoa nao encontrada");
		}

		LocalDate data = Util.validaDataDeInicio(dataDeInicio);

		Deputado deputado = buscaDeputado(dni);
		if (deputado != null) {
			throw new Exception("Deputado já cadastrado");
		}

		Util.validaPartido(pessoa);

		deputado = new Deputado(pessoa.getNome(), pessoa.getDni(), pessoa.getEstado(),
				pessoa.getInteresses(), pessoa.getPartido(), data);

		deputados.add(deputado);
	}


	/**
	 * Metodo que busca uma pessoa pelo DNI
	 *
	 * @param dni Numero identificador
	 * @return Pessoa
	 */
	public Pessoa buscaPessoa(String dni) {
		Pessoa pessoaRetorno = null;

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getDni().equals(dni)) {
				pessoaRetorno = pessoa;
			}
		}
		return pessoaRetorno;
	}

	/**
	 * Metodo que busca um deputado pelo DNI
	 *
	 * @param dni Numero identificador
	 * @return Deputado
	 */
	public Deputado buscaDeputado(String dni) {
		Deputado deputadoRetorno = null;

		for (Deputado deputado : deputados) {
			if (deputado.getDni().equals(dni)) {
				deputadoRetorno = deputado;
			}
		}
		return deputadoRetorno;
	}


	/**
	 * Metodo para exibir uma pessoa a partir do DNI
	 * @param dni identificador da pessoa
	 * @return String formatada de exibição
	 * @throws Exception
	 */
	public String exibirPessoa(String dni) throws Exception {

		String partido = "";
		String interesses = "";

		Util.validaCampo(dni, "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
		Util.validaDNI(dni, "Erro ao exibir pessoa: dni invalido");
		Pessoa pessoa = buscaPessoa(dni);

		if (pessoa != null) {
			if (pessoa.getPartido() != null && !pessoa.getPartido().isEmpty()) {
				partido += " - " + pessoa.getPartido();
			}
			if (pessoa.getInteresses() != null && !pessoa.getInteresses().isEmpty()) {
				interesses += " - Interesses: " + pessoa.getInteresses();
			}

			Deputado deputado = buscaDeputado(dni);

			if (deputado != null) {
				return "POL: " + deputado.getNome() + " - " + deputado.getDni() + " (" + deputado.getEstado()
						+ ") - " + deputado.getPartido() +
						interesses + " - " + Util.dataFormatada(deputado.getDataDeInicio()) + " - "
						+ deputado.getLeisAprovadas() + " Leis";
			} else {
				return pessoa.getNome() + " - " + pessoa.getDni() + " (" + pessoa.getEstado() + ")" + partido
						+ interesses;
			}

		}

		throw new Exception("Erro ao exibir pessoa: pessoa nao encontrada");


	}


	/**
	 * Cadastra um partido na base do governo
	 *
	 * @param nomePartido
	 */
	public void cadastrarPartido(String nomePartido) throws Exception {
		Util.validaCampo(nomePartido, "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
		Partido partido = new Partido(nomePartido);
		this.baseGoverno.add(partido);
	}

	/**
	 * Retorna a lista de partidos em ordem lexicografica
	 *
	 * @return string com a lista de partidos
	 */
	public String exibirBase() {
		Collections.sort(this.baseGoverno);
		String retorno = "";
		if (this.baseGoverno.size() > 0) {
			int i = 0;
			for (Partido partido: baseGoverno) {
				retorno += partido.getPartido();
				if (i < this.baseGoverno.size() - 1) {
					retorno += ",";
				}
				i++;
			}
		}
		return retorno;
	}

	/**
	 * Metodo para cadastrar comissao
	 *
	 * @param tema       nome da pessoa
	 * @param politicos  DNI (Documento Nacional de Identificacao) da pessoa
	 * @throws Exception excecao lançada caso DNI ja exista
	 */
	public void cadastrarComissao(String tema, String politicos) throws Exception {
		Util.validaCampo(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
		Util.validaCampo(politicos, "Erro ao cadastrar comissao: lista de politicos nao pode ser vazio " +
				"ou nulo");

		if (comissoes.contains(buscaComissao(tema))) {
			throw new Exception("Erro ao cadastrar comissao: tema existente");
		}

		verificaDNIs(politicos);

		comissoes.add(new Comissao(tema, politicos));

	}

	/**
	 * Busca uma comissao atraves do tema
	 *
	 * @param tema a ser buscado
	 * @return	Comissao
	 */
	private Comissao buscaComissao(String tema) {
		for (Comissao comissao: this.comissoes) {
			if(comissao.getTema().equals(tema)) {
				return comissao;
			}
		}
		return null;
	}


	/**
	 * Verifica se a lista de DNI's é válido
	 *
	 * @param listaDNI lista de DNI's a ser analizado
	 * @throws Exception
	 */
	public void verificaDNIs(String listaDNI) throws Exception {
		String[] listaPoliticos = listaDNI.split(",");
		for (int i = 0; i < listaPoliticos.length; i++) {
			Util.validaDNI(listaPoliticos[i], "Erro ao cadastrar comissao: dni invalido");
			if (buscaPessoa(listaPoliticos[i]) == null) {
				throw new Exception("Erro ao cadastrar comissao: pessoa inexistente");
			}
			if (buscaDeputado(listaPoliticos[i]) == null) {
				throw new Exception("Erro ao cadastrar comissao: pessoa nao eh deputado");
			}
		}
	}

	/**
	 * Cadastra projeto de lei
	 *
	 * @param dni 		 DNI do autor do projeto
	 * @param ano 		 ano de autoria do projeto
	 * @param ementa	 ementa do projeto
	 * @param interesse  interesses relacionados ao projeto
	 * @param url		 link do projeto
	 * @param conclusivo se é conclusivo
	 * @throws Exception
	 */
	public void cadastrarPL(String dni, int ano, String ementa, String interesse, String url, boolean conclusivo)
			throws Exception {
		validaCampos(dni, ano, ementa, interesse, url);

		int indice = 1;

		if (codigosPL.size() > 0) {
			indice = codigosPL.get(ano) + 1;
		}

		codigosPL.put(ano, indice);

		String codigo = "PL " + indice + "/" + ano;

		Projeto pl = new PL(codigo, dni, ano, ementa, interesse, url, conclusivo);

		projetos.add(pl);

	}

	/**
	 * Cadastra projeto de lei complementar
	 *
	 * @param dni 		 DNI do autor do projeto
	 * @param ano 		 ano de autoria do projeto
	 * @param ementa	 ementa do projeto
	 * @param interesse  interesses relacionados ao projeto
	 * @param url		 link do projeto
	 * @param artigos    artigos a serem alterados ou complementados
	 * @throws Exception
	 */
	public void cadastrarPLP(String dni, int ano, String ementa, String interesse, String url, String artigos)
			throws Exception {
		Util.validaCampo(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		validaCampos(dni, ano, ementa, interesse, url);

		int indice = 1;

		if (codigosPLP.size() > 0) {
			indice = codigosPLP.get(ano) + 1;
		}

		codigosPLP.put(ano, indice);

		String codigo = "PLP " + indice + "/" + ano;

		Projeto plp = new PLP(codigo, dni, ano, ementa, interesse, url, artigos);

		projetos.add(plp);

	}

	/**
	 * Cadastra uma proposta de emenda a constituição
	 *
	 * @param dni 		 DNI do autor do projeto
	 * @param ano 		 ano de autoria do projeto
	 * @param ementa	 ementa do projeto
	 * @param interesse  interesses relacionados ao projeto
	 * @param url		 link do projeto
	 * @param artigos    artigos a serem alterados ou complementados
	 * @throws Exception
	 */
	public void cadastrarPEC(String dni, int ano, String ementa, String interesse, String url, String artigos) throws
			Exception {

		Util.validaCampo(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		validaCampos(dni, ano, ementa, interesse, url);

		int indice = 1;

		if (codigosPEC.size() > 0) {
			indice = codigosPEC.get(ano) + 1;
		}

		codigosPEC.put(ano, indice);

		String codigo = "PEC " + indice + "/" + ano;

		Projeto pec = new PEC(codigo, dni, ano, ementa, interesse, url, artigos);

		projetos.add(pec);

	}

	/**
	 * Verifica e lança exceções em caso de entradas inválidas
	 *
	 * @param dni 		 DNI do autor do projeto
	 * @param ano 		 ano de autoria do projeto
	 * @param ementa	 ementa do projeto
	 * @param interesse  interesses relacionados ao projeto
	 * @param url		 link do projeto
	 * @throws Exception
	 */
	private void validaCampos(String dni, int ano, String ementa, String interesse, String url) throws
			Exception{
		Util.validaCampo(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		Util.validaCampo(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		Util.validaCampo(interesse, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		Util.validaCampo(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		Util.validaDNI(dni, "Erro ao cadastrar projeto: dni invalido");

		if (buscaPessoa(dni) == null) {
			throw new Exception("Erro ao cadastrar projeto: pessoa inexistente");
		}
		if (buscaDeputado(dni) == null) {
			throw new Exception("Erro ao cadastrar projeto: pessoa nao eh deputado");
		}

		if (ano < 1988) {
			throw new Exception("Erro ao cadastrar projeto: ano anterior a 1988");
		}
		if (ano > LocalDate.now().getYear()) {
			throw new Exception("Erro ao cadastrar projeto: ano posterior ao ano atual");
		}
	}

	/**
	 * Exibe os detalhes do projeto
	 *
	 * @param codigo codigo do projeto
	 * @return String com os detalhes do projeto
	 */
	public String exibirProjeto(String codigo) {
		Projeto projeto = buscaProjeto(codigo);

		if (projeto != null) {

			if (projeto instanceof PL) {
				PL pl = (PL) projeto;
				String conclusivo= "";
				if (pl.isConclusivo()) {
					conclusivo = "Conclusiva - ";
				}
				return "Projeto de Lei - " + pl.getCodigo() + " - " + pl.getDni() + " - " + pl.getEmenta()
						+ " - " + conclusivo + pl.getSituacao();

			}

			if (projeto instanceof PLP) {
				PLP plp = (PLP) projeto;
				return "Projeto de Lei Complementar - " + plp.getCodigo() + " - " + plp.getDni() + " - " + plp.getEmenta()
						+ " - " + Util.formataArtigos(plp.getArtigos()) + " - " + plp.getSituacao();

			}

			if (projeto instanceof PEC) {
				PEC pec = (PEC) projeto;
				return "Projeto de Emenda Constitucional - " + pec.getCodigo() + " - " + pec.getDni() + " - " + pec.getEmenta()
						+ " - " + Util.formataArtigos(pec.getArtigos()) + " - " + pec.getSituacao();

			}
		}
		return "";
	}

	/**
	 * Busca projeto atraves do código,
	 *
	 * @param codigo  codigo do projeto
	 * @return Projeto
	 */
	public Projeto buscaProjeto (String codigo){
		for (Projeto projeto : projetos) {
			if (projeto.getCodigo().equals(codigo)) {
				return projeto;
			}
		}
		return null;
	}

}