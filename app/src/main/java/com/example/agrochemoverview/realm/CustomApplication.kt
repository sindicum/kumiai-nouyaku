package com.example.agrochemoverview.realm

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class CustomApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        val config = RealmConfiguration.Builder()
            .assetFile("default.realm")
            .readOnly()
            .build()
        Realm.setDefaultConfiguration(config)

    }
}