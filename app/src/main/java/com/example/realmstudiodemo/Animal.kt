package com.example.realmstudiodemo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Animal (@PrimaryKey var animalID : Int = 0 ,  var name : String = "" ,  var age : Int = 0 ) : RealmObject()

