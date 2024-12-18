package com.example.gmailapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var createAccountButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.next)
        createAccountButton = findViewById(R.id.CreateAccount)


        loginButton.setOnClickListener {
            validateLogin()
        }


        createAccountButton.setOnClickListener {

            Toast.makeText(this, "Create Account clicked", Toast.LENGTH_SHORT).show()
        }
    }


    private fun validateLogin() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()


        if (email == "test@example.com" && password == "password123") {

            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            finish()
        } else {

            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
        }
    }
}
