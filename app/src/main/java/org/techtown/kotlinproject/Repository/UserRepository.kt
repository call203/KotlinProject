package org.techtown.kotlinproject.Repository

import android.app.Application
import org.techtown.kotlinproject.Room.User
import org.techtown.kotlinproject.Room.UserDao
import org.techtown.kotlinproject.Room.UserDatabase
import kotlin.contracts.contract

class UserRepository(application: Application){
    private val UserDatabase = org.techtown.kotlinproject.Room.UserDatabase.getInstance(application)!!
    private val userDao: UserDao = UserDatabase.userDao()
    private val userForm: User = userDao.getUserForm()

    fun getUserForm(): User{
        return userForm;
    }

    fun insertUser(user:User){
        try{
            val thread = Thread(Runnable{
              userDao.insertUser(user)
            })
            thread.start()
        }catch(e:Exception){}
    }


}