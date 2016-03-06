package pt.rikmartins.clubemg.clubemgandroid.base;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import pt.rikmartins.clubemg.clubemgandroid.armazenamemto.dagger.ArmazenamentoModule;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger.DaggerSimpleRestComponent;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger.RestApiModule;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger.SimpleRestComponent;
import pt.rikmartins.clubemg.clubemgandroid.ui.publicacoes.PublicacoesActivity;

public class ClubeMGApplication extends Application {
    private ClubeMGComponent clubeMGComponent;
    private SimpleRestComponent simpleRestComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        clubeMGComponent = DaggerClubeMGApplication_ClubeMGComponent.builder()
                .armazenamentoModule(new ArmazenamentoModule(this)).build();
        simpleRestComponent = DaggerSimpleRestComponent.builder()
                .restApiModule(new RestApiModule(false)).build();
    }

    public static ClubeMGComponent getClubeMGComponent(Context context) {
        return ((ClubeMGApplication)context.getApplicationContext()).clubeMGComponent;
    }

    public static SimpleRestComponent getSimpleRestComponent(Context context) {
        return ((ClubeMGApplication)context.getApplicationContext()).simpleRestComponent;
    }

    @Singleton
    @Component(modules = {ArmazenamentoModule.class})
    public interface ClubeMGComponent {
        void inject(PublicacoesActivity publicacoesActivity);
        void inject(ClubeMGActivity clubeMGActivity);
    }
}
