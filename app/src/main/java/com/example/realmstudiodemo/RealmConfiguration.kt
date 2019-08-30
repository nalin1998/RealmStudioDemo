package com.example.realmstudiodemo

import io.realm.Realm
import io.realm.RealmConfiguration

class RealmConfiguration {
    companion object{
            val realmInstance: Realm = Realm.getInstance(
                RealmConfiguration.Builder()
                    .name("pool.realm")
                    .schemaVersion(3)
                    .initialData {
                        val animal1 = it.createObject(Animal::class.java,1)
                        animal1.age=3
                        animal1.name="Sheru"
                        val animal2 = it.createObject(Animal::class.java,2)
                        animal2.age=3
                        animal2.name="Sheru"
                        val animal3 = it.createObject(Animal::class.java,3)
                        animal3.age=3
                        animal3.name="Sheru"
                        val animal4 = it.createObject(Animal::class.java,4)
                        animal4.age=3
                        animal4.name="Sheru"
                        val animal5 = it.createObject(Animal::class.java,5)
                        animal5.age=3
                        animal5.name="Sheru"
                        val animal6 = it.createObject(Animal::class.java,6)
                        animal6.age=3
                        animal6.name="Sheru"
                        val animal7 = it.createObject(Animal::class.java,7)
                        animal7.age=3
                        animal7.name="Sheru"
                        val animal8 = it.createObject(Animal::class.java,8)
                        animal8.age=3
                        animal8.name="Sheru"
                    }
                    .build())
        }
    }

