package org.techtown.kotlinproject.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase: RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object{
        private var INSTANCE: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase?{
            if(INSTANCE == null){
                synchronized(ContactDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"contact")
                        .fallbackToDestructiveMigration() //기존의 테이블을 버리고 새로 사용
                        .build()
                }
            }
            return INSTANCE
        }
    }

}