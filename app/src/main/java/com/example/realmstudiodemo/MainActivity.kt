package com.example.realmstudiodemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.realmstudiodemo.RealmConfiguration.Companion.realmInstance
import io.realm.Realm
import io.realm.RealmResults

class MainActivity : AppCompatActivity() {


    private val realm = realmInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (realm.isAutoRefresh) {
            Log.v("Main Activity", "Auto-refresh is On")
        }
        //recommended to do changes to data only in presence of an event like button click or whatever....
        performTransaction()
        insertOrUpdateRealm()
        performAsyncTransaction()
        Log.v("Main Activity1", "no of objects is ${runQuery().size}")
    }

    private fun runQuery(): RealmResults<Animal> {
        //its a read query so no need use transactions
        return realm.where(Animal::class.java).greaterThan("age", 6).findAll()
    }

    private fun performTransaction() {
        realm.executeTransaction {
            for (i in 1..8) {
                val animal = realm.where(Animal::class.java).equalTo("animalID", i).findFirst()
                animal?.age = i
            }
        }
    }

    private fun insertOrUpdateRealm() {
        val newAnimal = Animal(9, "Machli", 9)
        realm.executeTransaction {
            //inserts a new object in DB if not already existing with same value of primary key else updates it
            it.copyToRealmOrUpdate(newAnimal)
        }

    }

    private fun performAsyncTransaction() {
        //as some Transactions are blocked by others
        //we use async transactions to do writing on a background thread rather than UI thread

        realm.executeTransactionAsync( {
            val newAnimal = it.createObject(Animal::class.java, 100) as Animal
            newAnimal.age = 10
            newAnimal.name = "Motu"
        }, {
            Log.v("Main Activity", "no of objects is ${runQuery().size}")
        }, {

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        //we close realm instance to take care of memory deallocation
        realm.close()
    }


}