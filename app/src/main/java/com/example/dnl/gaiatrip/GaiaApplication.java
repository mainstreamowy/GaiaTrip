package com.example.dnl.gaiatrip;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class GaiaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder().name("gaia.realm").inMemory().build();
        Realm.setDefaultConfiguration(config);

    }
}