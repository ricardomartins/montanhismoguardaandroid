package pt.rikmartins.clubemg.clubemgandroid.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class ClubeMGActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ClubeMGApplication.getArmazenamentoComponent(this).inject(this);
        ClubeMGApplication.getComunicacoesComponent(this).inject(this);
    }
}
