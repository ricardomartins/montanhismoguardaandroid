package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pt.rikmartins.clubemg.clubemgandroid.base.ClubeMGActivity;

@Singleton
@Component(modules = RestApiModule.class)
public interface ComunicacoesComponent {
    void inject(ClubeMGActivity cmgActivity);
}
