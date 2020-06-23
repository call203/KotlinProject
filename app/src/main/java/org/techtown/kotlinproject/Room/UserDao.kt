package org.techtown.kotlinproject.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUserForm(): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user : User)
}