package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pt.rikmartins.clubemg.clubemgandroid.base.ClubeMGActivity;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.ActividadesService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.CategoriasService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.EtiquetasService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.PublicacoesService;
import pt.rikmartins.clubemg.clubemgandroid.ui.publicacoes.PublicacoesActivity;

@Singleton
@Component(modules = {RestApiModule.class})
public interface SimpleRestComponent {
    ActividadesService actividadesService();
    CategoriasService categoriasService();
    EtiquetasService etiquetasService();
    PublicacoesService publicacoesService();
}
