/**
 * Classe que representa um projeto
 *
 * @author Jessé Monteiro
 *
 */
public class Projeto {

    /**
     * String que representa o codigo do projeto
     */
    private String codigo;
    /**
     * String que representa o DNI do autor do projeto
     */
    private String dni;
    /**
     * Representa o ano de criação do projeto
     */
    private int ano;
    private String ementa;
    private String interesse;
    /**
     * String que representa o endereco do documento que descreve o teor, a lei e a sua justificativa do projeto
     */
    private String url;
    private String situacao;


    /**
     * Construto de Projeto
     *
     * @param codigo        codigo do projeto
     * @param dni           dni do autor do projeto
     * @param ano           ano de autoria do projeto
     * @param ementa        ementa do projeto
     * @param interesse     interesses relacionados ao projeto
     * @param url           endereco do documento que descreve o teor, a lei e a sua justificativa do projeto
     */
    public Projeto(String codigo, String dni, int ano, String ementa, String interesse, String url) {
        this.codigo = codigo;
        this.dni = dni;
        this.ano = ano;
        this.ementa = ementa;
        this.interesse = interesse;
        this.url = url;
        this.situacao = "EM VOTACAO (CCJC)";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSituacao() { return situacao; }

    public void setSituacao(String situacao) { this.situacao = situacao; }

}
