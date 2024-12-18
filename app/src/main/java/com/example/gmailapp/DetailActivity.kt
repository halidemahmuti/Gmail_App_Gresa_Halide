package com.example.gmailapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var profileImage: ImageView
    private lateinit var senderName: TextView
    private lateinit var subject: TextView
    private lateinit var fullMessage: TextView
    private lateinit var date: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_layout)

        profileImage = findViewById(R.id.details_profile_image)
        senderName = findViewById(R.id.details_sender_name)
        subject = findViewById(R.id.details_subject)
        fullMessage = findViewById(R.id.details_email_message)
        date = findViewById(R.id.details_time)
        backButton = findViewById(R.id.backButton)


        val profileImageResource = intent.getIntExtra("profileImage", 0)
        val senderNameText = intent.getStringExtra("senderName")
        val subjectText = intent.getStringExtra("subject")
        val fullMessageText = intent.getStringExtra("fullMessage")
        val dateText = intent.getStringExtra("date")


        profileImage.setImageResource(profileImageResource)
        senderName.text = senderNameText
        subject.text = subjectText
        fullMessage.text = fullMessageText
        date.text = dateText


        backButton.isEnabled = true
        backButton.setOnClickListener {
            finish()
        }
    }
}
