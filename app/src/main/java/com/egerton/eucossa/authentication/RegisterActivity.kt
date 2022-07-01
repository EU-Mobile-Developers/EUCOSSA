package com.egerton.eucossa.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egerton.eucossa.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}