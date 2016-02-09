package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1;

import java.util.List;

import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Actividade;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Pagina;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Publicacao;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Taxonomia;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface PublicacoesService {
    String PREFIXO = Base.PREFIXO_V1 + "/publicacoes";

    @GET(PREFIXO + "/")
    Observable<Pagina<Publicacao>> getPublicacoes(@Query("modificada") Long modificada,
                                                  @Query("limit") Integer limit,
                                                  @Query("offset") Integer offset);

    @GET(PREFIXO + "/{id_publicacao}/")
    Observable<Publicacao> getPublicacao(@Path("id_publicacao") Integer idPublicacao,
                                         @Query("modificada") Long modificada);

    @GET(PREFIXO + "/{id_publicacao}/categorias/")
    Observable<List<Taxonomia>> getCategoriasPublicacao(@Path("id_publicacao") Integer idPublicacao);

    @GET(PREFIXO + "/{id_publicacao}/etiquetas/")
    Observable<List<Taxonomia>> getEtiquetasPublicacao(@Path("id_publicacao") Integer idPublicacao);

    @GET(PREFIXO + "/{id_publicacao}/actividades/")
    Observable<List<Actividade>> getActividadesPublicacao(@Path("id_publicacao") Integer idPublicacao);
}
