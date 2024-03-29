package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1;

import java.util.List;

import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Actividade;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Pagina;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Publicacao;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Taxonomia;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PublicacoesService {
    String PREFIXO = Base.PREFIXO_V1 + "/publicacoes";

    @GET(PREFIXO + "/")
    Call<Pagina<Publicacao>> getPublicacoes(@Query("modificada") Long modificada);

    @GET(PREFIXO + "/")
    Call<Pagina<Publicacao>> getPublicacoes(@Query("limit") Integer limit,
                                                  @Query("offset") Integer offset);

    @GET(PREFIXO + "/")
    Call<Pagina<Publicacao>> getPublicacoes(@Query("modificada") Long modificada,
                                                  @Query("limit") Integer limit,
                                                  @Query("offset") Integer offset);

    @GET(PREFIXO + "/{id_publicacao}/")
    Call<Publicacao> getPublicacao(@Path("id_publicacao") Integer idPublicacao,
                                         @Query("modificada") Long modificada);

    @GET(PREFIXO + "/{id_publicacao}/categorias/")
    Call<List<Taxonomia>> getCategoriasPublicacao(@Path("id_publicacao") Integer idPublicacao);

    @GET(PREFIXO + "/{id_publicacao}/etiquetas/")
    Call<List<Taxonomia>> getEtiquetasPublicacao(@Path("id_publicacao") Integer idPublicacao);

    @GET(PREFIXO + "/{id_publicacao}/actividades/")
    Call<List<Actividade>> getActividadesPublicacao(@Path("id_publicacao") Integer idPublicacao);
}
