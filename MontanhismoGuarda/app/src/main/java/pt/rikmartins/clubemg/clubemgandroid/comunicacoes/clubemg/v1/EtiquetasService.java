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

public interface EtiquetasService {
    String PREFIXO = Base.PREFIXO_V1 + "/etiquetas";

    @GET(PREFIXO + "/")
    Call<Pagina<Taxonomia>> getEtiquetas(@Query("limit") Integer limit,
                                         @Query("offset") Integer offset);

    @GET(PREFIXO + "/{id_etiqueta}/")
    Call<Taxonomia> getEtiqueta(@Path("id_etiqueta") Integer idEtiqueta);

    @GET(PREFIXO + "/{id_etiqueta}/publicacoes/")
    Call<List<Publicacao>> getPublicacoesEtiqueta(@Path("id_etiqueta") Integer idEtiqueta);

    @GET(PREFIXO + "/{id_etiqueta}/actividades/")
    Call<List<Actividade>> getActividadesEtiqueta(@Path("id_etiqueta") Integer idEtiqueta);
}
