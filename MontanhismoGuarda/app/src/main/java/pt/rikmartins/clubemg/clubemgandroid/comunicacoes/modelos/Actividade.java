
package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;
import org.joda.time.Instant;

public class Actividade implements Paginavel {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("designacao")
    @Expose
    private String designacao;
    @SerializedName("selo_temporal")
    @Expose
    private Instant seloTemporal;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("motivo_cancelamento")
    @Expose
    private String motivoCancelamento;
    @SerializedName("diahora_inicial")
    @Expose
    private DateTime diahoraInicial;
    @SerializedName("diahora_final")
    @Expose
    private DateTime diahoraFinal;
    @SerializedName("ligacao_imagem")
    @Expose
    private String ligacaoImagem;
    @SerializedName("texto")
    @Expose
    private String texto;
    @SerializedName("publicacoes")
    @Expose
    private String publicacoes;
    @SerializedName("categorias")
    @Expose
    private String categorias;
    @SerializedName("etiquetas")
    @Expose
    private String etiquetas;
    @SerializedName("inscricao_ate")
    @Expose
    private DateTime inscricaoAte;
    @SerializedName("localizacoes")
    @Expose
    private String localizacoes;
    @SerializedName("ponto_encontro")
    @Expose
    private Localizacao pontoEncontro;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Actividade() {
    }

    /**
     * 
     * @param texto
     * @param motivoCancelamento
     * @param localizacoes
     * @param diahoraInicial
     * @param url
     * @param diahoraFinal
     * @param id
     * @param publicacoes
     * @param estado
     * @param pontoEncontro
     * @param seloTemporal
     * @param etiquetas
     * @param categorias
     * @param ligacaoImagem
     * @param inscricaoAte
     * @param designacao
     */
    public Actividade(String url, Long id, String designacao, Instant seloTemporal, String estado, String motivoCancelamento, DateTime diahoraInicial, DateTime diahoraFinal, String ligacaoImagem, String texto, String publicacoes, String categorias, String etiquetas, DateTime inscricaoAte, String localizacoes, Localizacao pontoEncontro) {
        this.url = url;
        this.id = id;
        this.designacao = designacao;
        this.seloTemporal = seloTemporal;
        this.estado = estado;
        this.motivoCancelamento = motivoCancelamento;
        this.diahoraInicial = diahoraInicial;
        this.diahoraFinal = diahoraFinal;
        this.ligacaoImagem = ligacaoImagem;
        this.texto = texto;
        this.publicacoes = publicacoes;
        this.categorias = categorias;
        this.etiquetas = etiquetas;
        this.inscricaoAte = inscricaoAte;
        this.localizacoes = localizacoes;
        this.pontoEncontro = pontoEncontro;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The designacao
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * 
     * @param designacao
     *     The designacao
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * 
     * @return
     *     The seloTemporal
     */
    public Instant getSeloTemporal() {
        return seloTemporal;
    }

    /**
     * 
     * @param seloTemporal
     *     The selo_temporal
     */
    public void setSeloTemporal(Instant seloTemporal) {
        this.seloTemporal = seloTemporal;
    }

    /**
     * 
     * @return
     *     The estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * 
     * @param estado
     *     The estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * 
     * @return
     *     The motivoCancelamento
     */
    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    /**
     * 
     * @param motivoCancelamento
     *     The motivo_cancelamento
     */
    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    /**
     * 
     * @return
     *     The diahoraInicial
     */
    public DateTime getDiahoraInicial() {
        return diahoraInicial;
    }

    /**
     * 
     * @param diahoraInicial
     *     The diahora_inicial
     */
    public void setDiahoraInicial(DateTime diahoraInicial) {
        this.diahoraInicial = diahoraInicial;
    }

    /**
     * 
     * @return
     *     The diahoraFinal
     */
    public DateTime getDiahoraFinal() {
        return diahoraFinal;
    }

    /**
     * 
     * @param diahoraFinal
     *     The diahora_final
     */
    public void setDiahoraFinal(DateTime diahoraFinal) {
        this.diahoraFinal = diahoraFinal;
    }

    /**
     * 
     * @return
     *     The ligacaoImagem
     */
    public String getLigacaoImagem() {
        return ligacaoImagem;
    }

    /**
     * 
     * @param ligacaoImagem
     *     The ligacao_imagem
     */
    public void setLigacaoImagem(String ligacaoImagem) {
        this.ligacaoImagem = ligacaoImagem;
    }

    /**
     * 
     * @return
     *     The texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * 
     * @param texto
     *     The texto
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * 
     * @return
     *     The publicacoes
     */
    public String getPublicacoes() {
        return publicacoes;
    }

    /**
     * 
     * @param publicacoes
     *     The publicacoes
     */
    public void setPublicacoes(String publicacoes) {
        this.publicacoes = publicacoes;
    }

    /**
     * 
     * @return
     *     The categorias
     */
    public String getCategorias() {
        return categorias;
    }

    /**
     * 
     * @param categorias
     *     The categorias
     */
    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    /**
     * 
     * @return
     *     The etiquetas
     */
    public String getEtiquetas() {
        return etiquetas;
    }

    /**
     * 
     * @param etiquetas
     *     The etiquetas
     */
    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    /**
     * 
     * @return
     *     The inscricaoAte
     */
    public DateTime getInscricaoAte() {
        return inscricaoAte;
    }

    /**
     * 
     * @param inscricaoAte
     *     The inscricao_ate
     */
    public void setInscricaoAte(DateTime inscricaoAte) {
        this.inscricaoAte = inscricaoAte;
    }

    /**
     * 
     * @return
     *     The localizacoes
     */
    public String getLocalizacoes() {
        return localizacoes;
    }

    /**
     * 
     * @param localizacoes
     *     The localizacoes
     */
    public void setLocalizacoes(String localizacoes) {
        this.localizacoes = localizacoes;
    }

    /**
     * 
     * @return
     *     The pontoEncontro
     */
    public Localizacao getPontoEncontro() {
        return pontoEncontro;
    }

    /**
     * 
     * @param pontoEncontro
     *     The ponto_encontro
     */
    public void setPontoEncontro(Localizacao pontoEncontro) {
        this.pontoEncontro = pontoEncontro;
    }

}
