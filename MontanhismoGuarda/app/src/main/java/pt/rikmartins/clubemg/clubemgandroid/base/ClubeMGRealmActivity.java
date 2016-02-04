package pt.rikmartins.clubemg.clubemgandroid.base;

import javax.inject.Inject;

import io.realm.Realm;

public abstract class ClubeMGRealmActivity extends ClubeMGActivity {
    @Inject Realm realmInstance;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realmInstance != null)
            realmInstance.close();
    }
}
