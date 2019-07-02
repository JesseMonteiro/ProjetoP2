/**
 * Classe que representa um Projeto de Lei Complementar
 *
 * @author Jesse Monteiro
 */
public class PLP extends Projeto {

    /**
     * Artigos a serem alterados ou emendados
     */
    private String artigos;

    /**
     * Construtor de Projeto de lei Complementar
     *
     * @param codigo        codigo do projeto
     * @param dni           dni do autor do projeto
     * @param ano           ano de autoria do projeto
     * @param ementa        ementa do projeto
     * @param interesse     interesses relacionados ao projeto
     * @param url           endereco do documento que descreve o teor, a lei e a sua justificativa do projeto
     * @param artigos       artigos a serem alterado ou emendado
     */
    public PLP(String codigo, String dni, int ano, String ementa, String interesse, String url, String artigos) {
        super(codigo, dni, ano, ementa, interesse, url);
        this.artigos =  artigos;
    }

    public String getArtigos() { return artigos; }

    public void setArtigos(String artigos) {
        this.artigos = artigos;
    }

}