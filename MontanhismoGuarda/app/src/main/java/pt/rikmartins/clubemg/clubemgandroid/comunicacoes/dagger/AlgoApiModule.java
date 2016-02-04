package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

@Module
public class AlgoApiModule {
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
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Named("noticiasUrl")
    String provideNoticiasApiUrl() {
        return "http://www.vogella.com"; // TODO: Url do ponto de acesso na página do clube
    }
}
