package pt.rikmartins.clubemg.clubemgandroid.bd.modelos;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Noticia extends RealmObject {
    @PrimaryKey
    private long idNoticia;
    private String url;
    private String titulo;
    private String subtitulo;
    private String texto;
    private String endNoticia;
    private String endImg;
    private boolean destacada;
    private Long modifiedUnixTimestamp;
    private RealmList<Categoria> categorias;
    private RealmList<Etiqueta> etiquetas;
    private RealmList<Ligacao> ligacoes;

    public long getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(long idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEndNoticia() {
        return endNoticia;
    }

    public void setEndNoticia(String endNoticia) {
        this.endNoticia = endNoticia;
    }

    public String getEndImg() {
        return endImg;
    }

    public void setEndImg(String endImg) {
        this.endImg = endImg;
    }

    public boolean isDestacada() {
        return destacada;
    }

    public void setDestacada(boolean destacada) {
        this.destacada = destacada;
    }

    public Long getModifiedUnixTimestamp() {
        return modifiedUnixTimestamp;
    }

    public void setModifiedUnixTimestamp(Long modifiedUnixTimestamp) {
        this.modifiedUnixTimestamp = modifiedUnixTimestamp;
    }

    public RealmList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(RealmList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public RealmList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(RealmList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public RealmList<Ligacao> getLigacoes() {
        return ligacoes;
    }

    public void setLigacoes(RealmList<Ligacao> ligacoes) {
        this.ligacoes = ligacoes;
    }
}
