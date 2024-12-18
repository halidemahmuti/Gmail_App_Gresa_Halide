package com.example.gmailapp

import Gmail
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.gmailapp.adapter.GmailAdapter

class ListActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: GmailAdapter
    private val gmailList = mutableListOf<Gmail>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)

        listView = findViewById(R.id.list_view)


        addDummyData()

        adapter = GmailAdapter(this, gmailList)
        listView.adapter = adapter

        val sortNewestButton: Button = findViewById(R.id.button_sort_newest)
        val sortOldestButton: Button = findViewById(R.id.button_sort_oldest)

        sortNewestButton.setOnClickListener {
            sortListByNewest()
        }

        sortOldestButton.setOnClickListener {
            sortListByOldest()
        }


        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedGmail = gmailList[position]


            val intent = Intent(this@ListActivity, DetailActivity::class.java).apply {
                // Pass the Gmail details via Intent
                putExtra("profileImage", selectedGmail.profileImageResource)
                putExtra("senderName", selectedGmail.senderName)
                putExtra("subject", selectedGmail.subject)
                putExtra("fullMessage", selectedGmail.fullMessage)
                putExtra("date", selectedGmail.date)
            }

            startActivity(intent)
        }
    }


    private fun addDummyData() {
        gmailList.add(Gmail("John Doe", "Subject 1", "Short message preview", "This is the full message body.", "10:30 AM", R.drawable.profile1))
        gmailList.add(Gmail("Jane Smith", "Subject 2", "Short message preview", "This is the full message body.", "9:00 AM", R.drawable.profile2))
        // Add more dummy data as needed
    }


    private fun sortListByNewest() {
        gmailList.sortByDescending { it.date } // Ensure the date is in the correct format for sorting
        adapter.notifyDataSetChanged()
    }


    private fun sortListByOldest() {
        gmailList.sortBy { it.date } // Ensure the date is in the correct format for sorting
        adapter.notifyDataSetChanged()
    }
}
