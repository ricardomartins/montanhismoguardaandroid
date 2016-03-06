package pt.rikmartins.clubemg.clubemgandroid.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Singleton;

import butterknife.Bind;
import butterknife.ButterKnife;
import dagger.Component;
import pt.rikmartins.clubemg.clubemgandroid.R;
import pt.rikmartins.clubemg.clubemgandroid.armazenamemto.dagger.ArmazenamentoModule;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.RXSubscriptionHolder;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger.RestApiModule;
import pt.rikmartins.clubemg.clubemgandroid.ui.publicacoes.PublicacoesActivity;
import rx.Subscription;

public abstract class ClubeMGActivity extends AppCompatActivity implements RXSubscriptionHolder {
    @Bind(R.id.toolbar)
    protected Toolbar toolbar;

    private final List<Subscription> subscriptionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
    }

    public abstract
    @LayoutRes
    int getContentViewId();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        for (Iterator<Subscription> iterator = subscriptionList.iterator() ; iterator.hasNext() ; ) {
            Subscription subscription = iterator.next();
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
                iterator.remove();
            }
        }
    }

    @Override
    public void addSubscription(@NonNull Subscription subscription) {
        subscriptionList.add(subscription);
    }

    @Override
    public void removeSubscription(@NonNull Subscription subscription) {
        subscriptionList.remove(subscription);
    }
}
