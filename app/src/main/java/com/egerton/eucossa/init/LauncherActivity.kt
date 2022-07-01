package com.egerton.eucossa.init

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egerton.eucossa.MainActivity
import com.egerton.eucossa.authentication.LoginActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.concurrent.schedule

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mAuth = Firebase.auth
        Timer("launch",false).schedule(100){
            if (mAuth.currentUser?.uid == null){
                //not logged in go to log in
                startlogin()
            }else {
                //go to homepage
                gohome()
            }
        }

    }

    private fun gohome() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    private fun startlogin() {
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
}