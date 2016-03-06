package pt.rikmartins.clubemg.clubemgandroid.comunicacoes;

import android.support.annotation.NonNull;

import rx.Subscription;

public interface RXSubscriptionHolder {
    void addSubscription(@NonNull Subscription subscription);
    void removeSubscription(@NonNull Subscription subscription);
}
