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

public interface ActividadesService {
    String PREFIXO = Base.PREFIXO_V1 + "/actividades";

    @GET(PREFIXO + "/")
    Call<Pagina<Actividade>> getActividades(@Query("modificado") Long modificado,
                                                  @Query("dia_inicial") String diaInicial,
                                                  @Query("dia_final") String diaFinal,
                                                  @Query("ano") Integer ano,
                                                  @Query("mes") Short mes,
                                                  @Query("dia_mes") Short diaMes,
                                                  @Query("estado") String estado,
                                                  @Query("limit") Integer limit,
                                                  @Query("offset") Integer offset);

    @GET(PREFIXO + "/{id_actividade}/")
    Call<Actividade> getActividade(@Path("id_actividade") Integer idActividade,
                                         @Query("modificada") Long modificada);

    @GET(PREFIXO + "/{id_actividade}/categorias/")
    Call<List<Taxonomia>> getCategoriasActividade(@Path("id_actividade") Integer idActividade);

    @GET(PREFIXO + "/{id_actividade}/etiquetas/")
    Call<List<Taxonomia>> getEtiquetasActividade(@Path("id_actividade") Integer idActividade);

    @GET(PREFIXO + "/{id_actividade}/publicacoes/")
    Call<List<Publicacao>> getPublicacoesActividade(@Path("id_actividade") Integer idActividade);

    @GET(PREFIXO + "/{id_actividade}/localizacoes/")
    Call<List<Publicacao>> getLocalizacoesActividade(@Path("id_actividade") Integer idActividade);
}
