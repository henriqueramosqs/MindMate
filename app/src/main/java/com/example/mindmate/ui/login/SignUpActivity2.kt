package com.example.mindmate.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mindmate.R
import com.example.mindmate.Volunteer
import com.example.mindmate.ChatActivity

class SignUpActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)

        val volunteerBtt: Button = findViewById<Button>(R.id.goToVolunteer)
        val talkToSomeone: Button = findViewById<Button>(R.id.tkto)

        volunteerBtt.setOnClickListener {
            Intent(this,Volunteer::class.java).also{
                startActivity(it)
            }
        }

        talkToSomeone.setOnClickListener {
            Intent(this, ChatActivity::class.java).also{
            startActivity(it)
        }}

    }
}