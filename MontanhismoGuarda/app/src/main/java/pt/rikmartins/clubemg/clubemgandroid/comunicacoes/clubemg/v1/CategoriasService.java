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

public interface CategoriasService {
    String PREFIXO = Base.PREFIXO_V1 + "/categorias";

    @GET(PREFIXO + "/")
    Call<Pagina<Taxonomia>> getCategorias(@Query("limit") Integer limit,
                                          @Query("offset") Integer offset);

    @GET(PREFIXO + "/{id_categoria}/")
    Call<Taxonomia> getCategoria(@Path("id_categoria") Integer idCategoria);

    @GET(PREFIXO + "/{id_categoria}/publicacoes/")
    Call<List<Publicacao>> getPublicacoesCategoria(@Path("id_categoria") Integer idCategoria);

    @GET(PREFIXO + "/{id_categoria}/publicacoes/")
    Call<Pagina<Publicacao>> getPublicacoesCategoria(@Path("id_categoria") Integer idCategoria,
                                                         @Query("limit") Integer limit,
                                                         @Query("offset") Integer offset);

    @GET(PREFIXO + "/{id_categoria}/actividades/")
    Call<List<Actividade>> getActividadesCategoria(@Path("id_categoria") Integer idCategoria);
}
