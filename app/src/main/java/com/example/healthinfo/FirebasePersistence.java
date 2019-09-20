package com.example.healthinfo;

import com.google.firebase.database.FirebaseDatabase;

public class FirebasePersistence extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }
}
