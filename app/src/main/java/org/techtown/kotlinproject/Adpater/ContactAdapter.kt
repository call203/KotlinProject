package org.techtown.kotlinproject.Adpater


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.kotlinproject.R
import org.techtown.kotlinproject.Room.Contact

class ContactAdapter(val contactItemClick: (Contact) -> Unit, val contactItemLongClick: (Contact) -> Unit) : RecyclerView.Adapter<ContactAdapter.ViewHoler>() {
    private var contacts: List<Contact> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHoler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHoler(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        holder.bind(contacts[position])
    }

    inner class ViewHoler(itemView: View): RecyclerView.ViewHolder(itemView){
        private val nameTv = itemView.findViewById<TextView>(R.id.item_tv_name)
        private val numberTv = itemView.findViewById<TextView>(R.id.item_tv_number)
        private val initialTv = itemView.findViewById<TextView>(R.id.item_tv_initial)

        fun bind(contact: Contact){
            nameTv.text = contact.name
            numberTv.text = contact.number
            initialTv.text = contact.inital.toString()

            itemView.setOnClickListener {
                contactItemClick(contact)
            }

            itemView.setOnLongClickListener {
                contactItemLongClick(contact)
                true
            }

        }

    }
    fun setContacts(contacts: List<Contact>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }




}