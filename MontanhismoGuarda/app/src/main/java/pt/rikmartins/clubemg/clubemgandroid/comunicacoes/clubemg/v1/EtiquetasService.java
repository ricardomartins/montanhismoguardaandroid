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

public interface EtiquetasService {
    String PREFIXO = Base.PREFIXO_V1 + "/etiquetas";

    @GET(PREFIXO + "/")
    Observable<Pagina<Taxonomia>> getEtiquetas(@Query("limit") Integer limit,
                                               @Query("offset") Integer offset);

    @GET(PREFIXO + "/{id_etiqueta}/")
    Observable<Taxonomia> getEtiqueta(@Path("id_etiqueta") Integer idEtiqueta);

    @GET(PREFIXO + "/{id_etiqueta}/publicacoes/")
    Observable<List<Publicacao>> getPublicacoesEtiqueta(@Path("id_etiqueta") Integer idEtiqueta);

    @GET(PREFIXO + "/{id_etiqueta}/actividades/")
    Observable<List<Actividade>> getActividadesEtiqueta(@Path("id_etiqueta") Integer idEtiqueta);
}
