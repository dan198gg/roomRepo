package com.example.myroomproject

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.processor.Context
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities=[(User::class)], version = 1)
abstract class UserRoomDB:RoomDatabase() {
    abstract fun userDAO():UserDAO
    companion object{
        private var DBINSTANSE:UserRoomDB?= null
        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context: android.content.Context):UserRoomDB{
            synchronized(this){
                var instance= DBINSTANSE
                if (instance==null){
                    instance=
                        Room.databaseBuilder(context.applicationContext,UserRoomDB::class.java,"usersDB")
                            .fallbackToDestructiveMigration(false).build()
                    DBINSTANSE=instance
                }
                return instance
            }
        }
    }
}