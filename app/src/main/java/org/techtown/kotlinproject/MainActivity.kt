package org.techtown.kotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.kotlinproject.Adpater.ContactAdapter
import org.techtown.kotlinproject.Room.Contact
import org.techtown.kotlinproject.ViewModel.ContactViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ContactAdapter({contact->
            val intent = Intent(this, AddActivity::class.java)
            intent.putExtra(AddActivity.EXTRA_CONTACT_NAME,contact.name)
            intent.putExtra(AddActivity.EXTRA_CONTACT_NUMBER,contact.number)
            intent.putExtra(AddActivity.EXTRA_CONTACT_ID,contact.id)
            startActivity(intent)

        },{contact -> deleteDialog(contact)})

        val lm = LinearLayoutManager(this)
        main_recycleview.adapter = adapter
        main_recycleview.layoutManager = lm
        main_recycleview.setHasFixedSize(true)

        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)
        contactViewModel.getAll().observe(this, Observer<List<Contact>> { contacts ->
            adapter.setContacts(contacts!!)
        })
        main_button.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }
    private fun deleteDialog(contact: Contact) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Delete selected contact?")
            .setNegativeButton("NO") { _, _ -> }
            .setNegativeButton("YES") { _, _ ->
                contactViewModel.delete(contact)
            }
        builder.show()
    }
}
