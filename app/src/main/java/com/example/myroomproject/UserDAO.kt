package com.example.myroomproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    @Query("SELECT * FROM users")
    fun getUsers():LiveData<List<User>>

    @Insert
    fun addUser(user:User)

    @Query("DELETE FROM users WHERE userId=:id")
    fun delUser(id:Int)
}