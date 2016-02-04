package pt.rikmartins.clubemg.clubemgandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import pt.rikmartins.clubemg.clubemgandroid.base.ClubeMGActivity;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.RestApiV1;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Noticia;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class NoticiasActivity extends ClubeMGActivity {

    @Inject SharedPreferences sharedPreferences;
    @Inject private RestApiV1 apiV1Endpoint;

    @Bind(R.id.results) TextView ttt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        ButterKnife.bind(this);
    }

    public void obterNoticias(View view) {

        Observable<List<Noticia>> observable = apiV1Endpoint.getNoticias(null);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<List<Noticia>, List<pt.rikmartins.clubemg.clubemgandroid.bd.modelos.Categoria>>() {
                    @Override
                    public List<pt.rikmartins.clubemg.clubemgandroid.bd.modelos.Categoria> call(List<Noticia> noticias) {
                        return null;
                    }
                })
                .subscribe(new Action1<List<pt.rikmartins.clubemg.clubemgandroid.bd.modelos.Categoria>>() {
                    @Override
                    public void call(List<pt.rikmartins.clubemg.clubemgandroid.bd.modelos.Categoria> noticias) {
                        ttt.setText(noticias.toString());
                    }
                });
    }
}
