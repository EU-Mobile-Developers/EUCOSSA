package com.egerton.eucossa.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egerton.eucossa.R

class ResetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}