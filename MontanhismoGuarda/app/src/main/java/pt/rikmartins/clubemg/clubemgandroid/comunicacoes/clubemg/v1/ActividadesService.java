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

public interface ActividadesService {
    String PREFIXO = Base.PREFIXO_V1 + "/actividades";

    @GET(PREFIXO + "/")
    Observable<Pagina<Actividade>> getActividades(@Query("modificado") Long modificado,
                                                  @Query("dia_inicial") String diaInicial,
                                                  @Query("dia_final") String diaFinal,
                                                  @Query("ano") Integer ano,
                                                  @Query("mes") Short mes,
                                                  @Query("dia_mes") Short diaMes,
                                                  @Query("estado") String estado,
                                                  @Query("limit") Integer limit,
                                                  @Query("offset") Integer offset);

    @GET(PREFIXO + "/{id_actividade}/")
    Observable<Actividade> getActividade(@Path("id_actividade") Integer idActividade,
                                         @Query("modificada") Long modificada);

    @GET(PREFIXO + "/{id_actividade}/categorias/")
    Observable<List<Taxonomia>> getCategoriasActividade(@Path("id_actividade") Integer idActividade);

    @GET(PREFIXO + "/{id_actividade}/etiquetas/")
    Observable<List<Taxonomia>> getEtiquetasActividade(@Path("id_actividade") Integer idActividade);

    @GET(PREFIXO + "/{id_actividade}/publicacoes/")
    Observable<List<Publicacao>> getPublicacoesActividade(@Path("id_actividade") Integer idActividade);

    @GET(PREFIXO + "/{id_actividade}/localizacoes/")
    Observable<List<Publicacao>> getLocalizacoesActividade(@Path("id_actividade") Integer idActividade);
}
