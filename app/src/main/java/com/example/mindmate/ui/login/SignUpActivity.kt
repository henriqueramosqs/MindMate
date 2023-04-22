package com.example.mindmate.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mindmate.R
import com.example.mindmate.databinding.ActivityMainBinding

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val continueBtt: Button = findViewById<Button>(R.id.continueBtt_signup)
        continueBtt.setOnClickListener {
            Intent(this, SignUpActivity2::class.java).also{
                startActivity(it)
            }

        }
    }
}