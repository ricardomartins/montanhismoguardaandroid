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

public interface CategoriasService {
    String PREFIXO = Base.PREFIXO_V1 + "/categorias";

    @GET(PREFIXO + "/")
    Observable<Pagina<Taxonomia>> getCategorias(@Query("limit") Integer limit,
                                                @Query("offset") Integer offset);

    @GET(PREFIXO + "/{id_categoria}/")
    Observable<Taxonomia> getCategoria(@Path("id_categoria") Integer idCategoria);

    @GET(PREFIXO + "/{id_categoria}/publicacoes/")
    Observable<List<Publicacao>> getPublicacoesCategoria(@Path("id_categoria") Integer idCategoria);

    @GET(PREFIXO + "/{id_categoria}/actividades/")
    Observable<List<Actividade>> getActividadesCategoria(@Path("id_categoria") Integer idCategoria);
}
