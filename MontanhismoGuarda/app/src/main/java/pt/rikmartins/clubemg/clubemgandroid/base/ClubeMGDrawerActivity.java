package pt.rikmartins.clubemg.clubemgandroid.base;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;

import butterknife.Bind;
import pt.rikmartins.clubemg.clubemgandroid.R;

public abstract class ClubeMGDrawerActivity extends ClubeMGActivity {
    @Bind(R.id.layoutPublicacoes)
    protected DrawerLayout drawer;
    @Bind(R.id.navegacao)
    protected NavigationView navegacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
