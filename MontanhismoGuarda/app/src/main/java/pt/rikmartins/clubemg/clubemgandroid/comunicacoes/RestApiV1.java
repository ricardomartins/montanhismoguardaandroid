package pt.rikmartins.clubemg.clubemgandroid.comunicacoes;

import java.util.List;

import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Categoria;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Etiqueta;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Noticia;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface RestApiV1 {
    String V1_URL_PREFIX = "/api/v1";

    String NOTICIAS_PREFIX = V1_URL_PREFIX + "/noticias";
    String CATEGORIAS_PREFIX = V1_URL_PREFIX + "/categorias";
    String ETIQUETAS_PREFIX = V1_URL_PREFIX + "/etiquetas";

    @GET(NOTICIAS_PREFIX + "/")
    Observable<List<Noticia>> getNoticias(@Query("modificada") Long modificada);

    @GET(NOTICIAS_PREFIX + "/{id_noticia}/")
    Observable<Noticia> getNoticia(@Path("id_noticia") int idNoticia, @Query("modificada") Long modificada);

    @GET(CATEGORIAS_PREFIX + "/")
    Observable<List<Categoria>> getCategorias();

    @GET(CATEGORIAS_PREFIX + "/{id_categoria}/")
    Observable<Categoria> getCategoria(@Path("id_categoria") int idCategoria);

    @GET(CATEGORIAS_PREFIX + "/{id_categoria}/noticias/")
    Observable<List<Noticia>> getNoticiasDaCategoria(@Path("id_categoria") int idCategoria);

    @GET(ETIQUETAS_PREFIX + "/")
    Observable<List<Etiqueta>> getEtiquetas();

    @GET(ETIQUETAS_PREFIX + "/{id_etiqueta}/")
    Observable<Etiqueta> getEtiqueta(@Path("id_etiqueta") int idEtiqueta);

    @GET(ETIQUETAS_PREFIX + "/{id_etiqueta}/noticias/")
    Observable<List<Noticia>> getNoticiasDaEtiqueta(@Path("id_etiqueta") int idEtiqueta);
}
