package pt.rikmartins.clubemg.clubemgandroid.base;

import android.app.Application;
import android.content.Context;

import pt.rikmartins.clubemg.clubemgandroid.armazenamemto.dagger.ArmazenamentoComponent;
import pt.rikmartins.clubemg.clubemgandroid.armazenamemto.dagger.ArmazenamentoModule;
import pt.rikmartins.clubemg.clubemgandroid.armazenamemto.dagger.DaggerArmazenamentoComponent;

public class ClubeMGApplication extends Application {
    private ArmazenamentoComponent armazenamentoComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        armazenamentoComponent = DaggerArmazenamentoComponent.builder()
                .armazenamentoModule(new ArmazenamentoModule(this)).build();
    }

    public static ArmazenamentoComponent getStorageComponent(Context context) {
        return ((ClubeMGApplication)context.getApplicationContext()).armazenamentoComponent;
    }
}
