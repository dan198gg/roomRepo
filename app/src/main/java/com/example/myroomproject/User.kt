package com.example.myroomproject

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("users")
class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo("userId")
    var id: Int = 0

    @ColumnInfo("userName")
    var name: String = ""

    @ColumnInfo("userAge")
    var age:Int=0

    constructor(){}

    constructor(name:String,age:Int){
        this.name=name
        this.age=age
    }
}