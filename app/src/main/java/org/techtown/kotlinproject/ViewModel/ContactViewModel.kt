package org.techtown.kotlinproject.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import org.techtown.kotlinproject.Repository.ContactRepository
import org.techtown.kotlinproject.Room.Contact

class ContactViewModel(application: Application): AndroidViewModel(application){

    private val repository = ContactRepository(application)
    private val contacts = repository.getAll()

    fun getAll(): LiveData<List<Contact>>{
        return this.contacts
    }
    fun insert(contact: Contact){
        repository.insert(contact)
    }
    fun delete(contact:Contact){
        repository.delete(contact)
    }

}