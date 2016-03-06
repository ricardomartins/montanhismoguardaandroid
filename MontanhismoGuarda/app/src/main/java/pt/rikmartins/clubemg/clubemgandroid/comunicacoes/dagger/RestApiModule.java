package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.ActividadesService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.CategoriasService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.EtiquetasService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.PublicacoesService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RestApiModule {
    private static final String REST_API_URL = "http://ricardomartins.pythonanywhere.com/";
    private static final String LOCAL_REST_API_URL = "http://10.0.2.2:8000/";

    private boolean useApiOnLocalMachine;

    public RestApiModule(boolean useApiOnLocalMachine) {
        this.useApiOnLocalMachine = useApiOnLocalMachine;
    }

    @Provides
    @Singleton
    @Named("restApi")
    Gson provideRestApiGson() {
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    @Provides
    @Singleton
    @Named("restApi")
    Retrofit provideRestApiRetrofit(@Named("restApi") Gson gson, @Named("restApi") String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    PublicacoesService providePublicacoesService(@Named("restApi") Retrofit retrofit) {
        return retrofit.create(PublicacoesService.class);
    }

    @Provides
    @Singleton
    CategoriasService provideCategoriasService(@Named("restApi") Retrofit retrofit) {
        return retrofit.create(CategoriasService.class);
    }

    @Provides
    @Singleton
    EtiquetasService provideEtiquetasService(@Named("restApi") Retrofit retrofit) {
        return retrofit.create(EtiquetasService.class);
    }

    @Provides
    @Singleton
    ActividadesService provideActividadesService(@Named("restApi") Retrofit retrofit) {
        return retrofit.create(ActividadesService.class);
    }

    @Provides
    @Named("restApi")
    String provideRestApiUrl() {
        return useApiOnLocalMachine ? LOCAL_REST_API_URL : REST_API_URL;
    }
}
