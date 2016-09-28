package pt.rikmartins.clubemg.clubemgandroid.base;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;

import pt.rikmartins.clubemg.clubemgandroid.R;

public abstract class ClubeMGDrawerActivity extends ClubeMGActivity {
    protected DrawerLayout drawer;
    protected NavigationView navegacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawer = (DrawerLayout) findViewById(R.id.layoutPublicacoes);
        navegacao = (NavigationView) findViewById(R.id.navegacao);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
