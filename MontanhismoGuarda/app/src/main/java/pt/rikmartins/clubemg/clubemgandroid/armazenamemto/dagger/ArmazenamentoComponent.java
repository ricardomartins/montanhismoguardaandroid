package pt.rikmartins.clubemg.clubemgandroid.armazenamemto.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pt.rikmartins.clubemg.clubemgandroid.base.ClubeMGActivity;

@Singleton
@Component(modules = ArmazenamentoModule.class)
public interface ArmazenamentoComponent {
    void inject(ClubeMGActivity cmgActivity);
}
