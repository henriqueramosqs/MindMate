package com.example.mindmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mindmate.databinding.ActivityMainBinding
import com.example.mindmate.ui.login.LoginActivity
import com.example.mindmate.ui.login.SignUpActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginBtt: Button = binding.loginBtt
        val signUpBtt:Button = binding.sigupBtt

        loginBtt.setOnClickListener {
            Intent(this,LoginActivity::class.java).also {
                startActivity(it)
            }
        }

        signUpBtt.setOnClickListener {
            Intent(this, SignUpActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}