package com.example.realmstudiodemo

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration



class MyApp : Application() {


    override fun onCreate() {
        super.onCreate()
        //initializing realm
        Realm.init(this)
    }

}