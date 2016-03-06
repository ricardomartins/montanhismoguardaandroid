package pt.rikmartins.clubemg.clubemgandroid.ui.publicacoes;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import butterknife.Bind;
import pt.rikmartins.clubemg.clubemgandroid.R;
import pt.rikmartins.clubemg.clubemgandroid.base.ClubeMGApplication;
import pt.rikmartins.clubemg.clubemgandroid.base.ClubeMGDrawerActivity;

public class PublicacoesActivity extends ClubeMGDrawerActivity {

    @Inject
    SharedPreferences sharedPreferences;

    @Bind(R.id.main_content)
    CoordinatorLayout mainContent;
    @Bind(R.id.appbar)
    AppBarLayout appBar;
    @Bind(R.id.listaPublicacoes)
    RecyclerView listaPublicacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ClubeMGApplication.getClubeMGComponent(this).inject(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        new PublicacoesAdapter(this, R.layout.item_publicacao, listaPublicacoes, linearLayoutManager);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_publicacoes;
    }
}
