/**
 * Classe que representa um Projeto de Lei
 *
 * @author  Jesse Monteiro
 */
public class PL extends Projeto {

    /**
     * Flag que identifica se o projeto é conclusivo
     */
    private boolean conclusivo;

    /**
     * @param codigo        codigo do projeto
     * @param dni           dni do autor do projeto
     * @param ano           ano de autoria do projeto
     * @param ementa        ementa do projeto
     * @param interesse     interesses relacionados ao projeto
     * @param url           endereco do documento que descreve o teor, a lei e a sua justificativa do projeto
     * @param conclusivo    flag que identifica se o projeto é conclusivo
     */
    public PL(String codigo, String dni, int ano, String ementa, String interesse, String url, boolean conclusivo) {
        super(codigo, dni, ano, ementa, interesse, url);
        this.conclusivo = conclusivo;
    }

    public boolean isConclusivo() {
        return conclusivo;
    }

    public void setConclusivo(boolean conclusivo) {
        this.conclusivo = conclusivo;
    }

}
