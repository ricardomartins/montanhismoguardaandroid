package pt.rikmartins.clubemg.clubemgandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import pt.rikmartins.clubemg.clubemgandroid.base.ClubeMGActivity;
import pt.rikmartins.clubemg.clubemgandroid.bd.modelos.Categoria;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.CategoriasService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.EtiquetasService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.PublicacoesService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Pagina;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Publicacao;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class PublicacoesActivity extends ClubeMGActivity {

    @Inject SharedPreferences sharedPreferences;
    @Inject PublicacoesService publicacoesService;
    @Inject CategoriasService categoriasService;
    @Inject EtiquetasService etiquetasService;

    @Bind(R.id.drawer)
    DrawerLayout drawer;
    @Bind(R.id.main_content)
    CoordinatorLayout mainContent;
    @Bind(R.id.appbar)
    AppBarLayout appBar;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.viewpager)
    ViewPager viewPager;
    @Bind(R.id.navegacao_view)
    NavigationView navegacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicacoes);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
    }

//    public void obterNoticias(View view) {
//
//        Observable<Pagina<Publicacao>> observable = apiV1Endpoint.getPublicacoes(null, null, null);
//
//        observable.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(new Func1<Pagina<Publicacao>, List<pt.rikmartins.clubemg.clubemgandroid.bd.modelos.Categoria>>() {
//                    @Override
//                    public List<Categoria> call(Pagina<Publicacao> publicacaoPagina) {
//                        return null;
//                    }
//                })
//                .subscribe(new Action1<List<pt.rikmartins.clubemg.clubemgandroid.bd.modelos.Categoria>>() {
//                    @Override
//                    public void call(List<pt.rikmartins.clubemg.clubemgandroid.bd.modelos.Categoria> noticias) {
////                        ttt.setText(noticias.toString());
//                    }
//                });
//    }
}
