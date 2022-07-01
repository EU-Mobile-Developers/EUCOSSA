package com.egerton.eucossa.authentication

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.egerton.eucossa.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.maxkeppeler.sheets.core.ButtonStyle
import com.maxkeppeler.sheets.core.SheetStyle
import com.maxkeppeler.sheets.info.InfoSheet

class ResetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)
        val email = findViewById<TextInputEditText>(R.id.resetmail)
        val emailes = findViewById<TextInputLayout>(R.id.Remail)
        val reset = findViewById<Button>(R.id.sendReset)


        reset.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            val mail = email.text
            if (mail.isNullOrBlank()){
                emailes.error = "Cannot be empty"
            }else if(mail.contains(".") and mail.contains("@") and (mail.count() > 8)){
                val sheet = InfoSheet().build(this) {
                    cornerRadius(8F)
                    title("Email sent")
                    drawable(R.drawable.github)
                    positiveButtonColor(Color.BLUE)
                    negativeButtonColor(Color.GRAY)
                    negativeButtonStyle(ButtonStyle.OUTLINED)
                    positiveButtonStyle(ButtonStyle.NORMAL)
                    content("An Email has been sent to : $mail. \nIf nothing works for you open an issue on our github page and we'll look into it.")
                    style(SheetStyle.DIALOG)
                    onPositive {
                        val url = "https://github.com/EU-Mobile-Developers/EUCOSSA/issues"
                        val openurl=Intent(Intent.ACTION_VIEW)
                        openurl.data= Uri.parse(url)
                        startActivity(openurl)
                    }
                    onNegative {
                        startActivity(intent)
                        finish()
                    }
                }

                sheet.show()
            }else{
                emailes.error = "Invalid email"
            }

        }

    }



    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}