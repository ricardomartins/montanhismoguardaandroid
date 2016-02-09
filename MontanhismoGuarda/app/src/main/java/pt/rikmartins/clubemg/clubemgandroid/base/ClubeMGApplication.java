package pt.rikmartins.clubemg.clubemgandroid.base;

import android.app.Application;
import android.content.Context;

import pt.rikmartins.clubemg.clubemgandroid.armazenamemto.dagger.ArmazenamentoComponent;
import pt.rikmartins.clubemg.clubemgandroid.armazenamemto.dagger.ArmazenamentoModule;
import pt.rikmartins.clubemg.clubemgandroid.armazenamemto.dagger.DaggerArmazenamentoComponent;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger.ComunicacoesComponent;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger.DaggerComunicacoesComponent;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger.RestApiModule;

public class ClubeMGApplication extends Application {
    private ArmazenamentoComponent armazenamentoComponent;
    private ComunicacoesComponent comunicacoesComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        armazenamentoComponent = DaggerArmazenamentoComponent.builder()
                .armazenamentoModule(new ArmazenamentoModule(this)).build();
        comunicacoesComponent = DaggerComunicacoesComponent.builder()
                .restApiModule(new RestApiModule(false)).build(); // Mudar para true para usar a api na máquina local
    }

    public static ArmazenamentoComponent getArmazenamentoComponent(Context context) {
        return ((ClubeMGApplication)context.getApplicationContext()).armazenamentoComponent;
    }

    public static ComunicacoesComponent getComunicacoesComponent(Context context) {
        return ((ClubeMGApplication)context.getApplicationContext()).comunicacoesComponent;
    }
}
