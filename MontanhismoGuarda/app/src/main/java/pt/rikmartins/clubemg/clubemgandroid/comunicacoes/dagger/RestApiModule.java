package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.RestApiV1;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

@Module
public class RestApiModule {
    @Provides
    @Singleton
    @Named("restApi")
    Gson provideRestApiGson() {
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    @Provides
    @Singleton
    @Named("restApi")
    Retrofit provideRestApiRetrofit(@Named("restApi") Gson gson, @Named("localRestApi") String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    RestApiV1 provideRestApiV1(@Named("restApi") Retrofit retrofit) {
        return retrofit.create(RestApiV1.class);
    }

    @Provides
    @Named("restApi")
    String provideRestApiUrl() {
        return "http://www.google.com"; // TODO: Url do ponto de acesso no meu servidor
    }

    @Provides
    @Named("localRestApi")
    String provideRestV1Url() {
        return "http://10.0.2.2:8000/";
    }
}
