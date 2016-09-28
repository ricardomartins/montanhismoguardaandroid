package pt.rikmartins.clubemg.clubemgandroid.ui.actividades;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import pt.rikmartins.clubemg.clubemgandroid.R;
import pt.rikmartins.clubemg.clubemgandroid.base.ClubeMGDrawerActivity;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.CategoriasService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.EtiquetasService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.PublicacoesService;

public class CalendarioActividadesActivity extends ClubeMGDrawerActivity {

    @Inject SharedPreferences sharedPreferences;
    @Inject PublicacoesService publicacoesService;
    @Inject CategoriasService categoriasService;
    @Inject EtiquetasService etiquetasService;

    CoordinatorLayout mainContent;
    AppBarLayout appBar;
    RecyclerView recyclerViewPager;

    @Override
    public int getContentViewId() {
        return R.layout.activity_publicacoes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainContent = (CoordinatorLayout) findViewById(R.id.main_content);
        appBar = (AppBarLayout) findViewById(R.id.appbar);
        recyclerViewPager = (RecyclerView) findViewById(R.id.listaPublicacoes);
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
