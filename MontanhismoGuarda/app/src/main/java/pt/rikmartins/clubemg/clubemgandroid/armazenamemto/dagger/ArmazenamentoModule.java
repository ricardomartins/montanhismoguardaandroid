package pt.rikmartins.clubemg.clubemgandroid.armazenamemto.dagger;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pt.rikmartins.clubemg.clubemgandroid.base.ClubeMGApplication;

@Module
public class ArmazenamentoModule {
    private final ClubeMGApplication application;

    public ArmazenamentoModule(ClubeMGApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
