package org.techtown.kotlinproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_login.*
import org.techtown.kotlinproject.ViewModel.ContactViewModel
import org.techtown.kotlinproject.ViewModel.UserViewModel

class LoginActivity : AppCompatActivity(){

   // private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        userViewModel = ViewModelProviders.of(this).get(userViewModel::class.java)
//
//        if(intent !=null && intent.hasExtra(EXTRA_CONTACT_EMAIL) && intent.hasExtra(EXTRA_CONTACT_PASSWORD)){
//            email_et.setText(intent.getStringExtra(EXTRA_CONTACT_EMAIL))
//            password_et.setText(intent.getStringExtra(EXTRA_CONTACT_PASSWORD))
//        }

        signup_tb.setOnClickListener{
            val nextIntent = Intent(this,SignupActivity::class.java)
            startActivity(nextIntent)
        }
    }
    companion object{
        const val EXTRA_CONTACT_EMAIL = "EXTRA_CONTACT_EMAIL"
        const val EXTRA_CONTACT_PASSWORD = "EXTRA_CONTACT_PASSWORD"
    }
}