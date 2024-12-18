package com.example.gmailapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)


        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
    }
}
