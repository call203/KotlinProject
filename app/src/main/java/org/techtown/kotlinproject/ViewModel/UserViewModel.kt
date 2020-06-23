package org.techtown.kotlinproject.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import org.techtown.kotlinproject.Repository.ContactRepository
import org.techtown.kotlinproject.Repository.UserRepository
import org.techtown.kotlinproject.Room.Contact
import org.techtown.kotlinproject.Room.User

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val repository = UserRepository(application)
    private val user = repository.getUserForm()

    fun getUSerForm(): User {
        return this.user
    }
    fun insert(user: User){
        repository.insertUser(user)
    }
}