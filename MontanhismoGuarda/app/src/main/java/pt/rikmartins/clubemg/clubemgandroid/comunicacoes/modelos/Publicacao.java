package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Publicacao implements Paginavel {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("titulo")
    @Expose
    private String titulo;
    @SerializedName("identificador")
    @Expose
    private String identificador;
    @SerializedName("destacada")
    @Expose
    private Boolean destacada;
    @SerializedName("ligacao_imagem")
    @Expose
    private String ligacaoImagem;
    @SerializedName("selo_temporal")
    @Expose
    private Long seloTemporal;
    @SerializedName("conteudo")
    @Expose
    private String conteudo;
    @SerializedName("excerto")
    @Expose
    private String excerto;
    @SerializedName("categorias")
    @Expose
    private String categorias;
    @SerializedName("etiquetas")
    @Expose
    private String etiquetas;
    @SerializedName("ligacao_publicacao")
    @Expose
    private String ligacaoPublicacao;
    @SerializedName("data")
    @Expose
    private DateTime data;
    @SerializedName("data_modificacao")
    @Expose
    private DateTime dataModificacao;
    @SerializedName("actividades")
    @Expose
    private String actividades;

    /**
     * No args constructor for use in serialization
     */
    public Publicacao() {
    }

    /**
     * @param conteudo
     * @param ligacaoPublicacao
     * @param data
     * @param url
     * @param id
     * @param titulo
     * @param identificador
     * @param seloTemporal
     * @param etiquetas
     * @param categorias
     * @param actividades
     * @param ligacaoImagem
     * @param dataModificacao
     * @param destacada
     */
    public Publicacao(String url, Long id, String titulo, String identificador, Boolean destacada, String ligacaoImagem, Long seloTemporal, String conteudo, String excerto, String categorias, String etiquetas, String ligacaoPublicacao, DateTime data, DateTime dataModificacao, String actividades) {
        this.url = url;
        this.id = id;
        this.titulo = titulo;
        this.identificador = identificador;
        this.destacada = destacada;
        this.ligacaoImagem = ligacaoImagem;
        this.seloTemporal = seloTemporal;
        this.conteudo = conteudo;
        this.excerto = excerto;
        this.categorias = categorias;
        this.etiquetas = etiquetas;
        this.ligacaoPublicacao = ligacaoPublicacao;
        this.data = data;
        this.dataModificacao = dataModificacao;
        this.actividades = actividades;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return The titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo The titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return The identificador
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador The identificador
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * @return The destacada
     */
    public Boolean getDestacada() {
        return destacada;
    }

    /**
     * @param destacada The destacada
     */
    public void setDestacada(Boolean destacada) {
        this.destacada = destacada;
    }

    /**
     * @return The ligacaoImagem
     */
    public String getLigacaoImagem() {
        return ligacaoImagem;
    }

    /**
     * @param ligacaoImagem The ligacao_imagem
     */
    public void setLigacaoImagem(String ligacaoImagem) {
        this.ligacaoImagem = ligacaoImagem;
    }

    /**
     * @return The seloTemporal
     */
    public Long getSeloTemporal() {
        return seloTemporal;
    }

    /**
     * @param seloTemporal The selo_temporal
     */
    public void setSeloTemporal(Long seloTemporal) {
        this.seloTemporal = seloTemporal;
    }

    /**
     * @return The conteudo
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * @param conteudo The conteudo
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * @return The excerto
     */
    public String getExcerto() {
        return excerto;
    }

    /**
     * @param excerto The excerto
     */
    public void setExcerto(String excerto) {
        this.excerto = excerto;
    }
    /**
     * @return The categorias
     */
    public String getCategorias() {
        return categorias;
    }

    /**
     * @param categorias The categorias
     */
    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    /**
     * @return The etiquetas
     */
    public String getEtiquetas() {
        return etiquetas;
    }

    /**
     * @param etiquetas The etiquetas
     */
    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    /**
     * @return The ligacaoPublicacao
     */
    public String getLigacaoPublicacao() {
        return ligacaoPublicacao;
    }

    /**
     * @param ligacaoPublicacao The ligacao_publicacao
     */
    public void setLigacaoPublicacao(String ligacaoPublicacao) {
        this.ligacaoPublicacao = ligacaoPublicacao;
    }

    /**
     * @return The data
     */
    public DateTime getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(DateTime data) {
        this.data = data;
    }

    /**
     * @return The dataModificacao
     */
    public DateTime getDataModificacao() {
        return dataModificacao;
    }

    /**
     * @param dataModificacao The data_modificacao
     */
    public void setDataModificacao(DateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    /**
     * @return The actividades
     */
    public String getActividades() {
        return actividades;
    }

    /**
     * @param actividades The actividades
     */
    public void setActividades(String actividades) {
        this.actividades = actividades;
    }
}
