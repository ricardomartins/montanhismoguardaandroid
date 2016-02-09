package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Taxonomia implements Paginavel {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("identificador")
    @Expose
    private String identificador;
    @SerializedName("descricao")
    @Expose
    private String descricao;
    @SerializedName("ligacao")
    @Expose
    private String ligacao;
    @SerializedName("publicacoes")
    @Expose
    private String publicacoes;
    @SerializedName("actividades")
    @Expose
    private String actividades;

    /**
     * No args constructor for use in serialization
     */
    public Taxonomia() {
    }

    /**
     * @param ligacao
     * @param id
     * @param publicacoes
     * @param identificador
     * @param nome
     * @param actividades
     * @param descricao
     * @param url
     */
    public Taxonomia(String url, Long id, String nome, String identificador, String descricao, String ligacao, String publicacoes, String actividades) {
        this.url = url;
        this.id = id;
        this.nome = nome;
        this.identificador = identificador;
        this.descricao = descricao;
        this.ligacao = ligacao;
        this.publicacoes = publicacoes;
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
     * @return The nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome The nome
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @return The descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao The descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return The ligacao
     */
    public String getLigacao() {
        return ligacao;
    }

    /**
     * @param ligacao The ligacao
     */
    public void setLigacao(String ligacao) {
        this.ligacao = ligacao;
    }

    /**
     * @return The publicacoes
     */
    public String getPublicacoes() {
        return publicacoes;
    }

    /**
     * @param publicacoes The publicacoes
     */
    public void setPublicacoes(String publicacoes) {
        this.publicacoes = publicacoes;
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
