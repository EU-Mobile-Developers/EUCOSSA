package com.egerton.eucossa.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.egerton.eucossa.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //reference the ui views
        val fgtPassword = findViewById<TextView>(R.id.forgtotpassword)
        val login = findViewById<Button>(R.id.login)
        val register = findViewById<TextView>(R.id.noaccount)

        //on click events
        fgtPassword.setOnClickListener {
            startActivity(Intent(this,ResetActivity::class.java))

        }
        login.setOnClickListener {

        }
        register.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        }
    }
}