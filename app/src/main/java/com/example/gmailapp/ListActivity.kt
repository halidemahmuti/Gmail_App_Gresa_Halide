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
        gmailList.add(
            Gmail(
                "John Doe",
                "Subject 1",
                "Short message preview",
                "This is the full message body.",
                "10:30 AM",
                R.drawable.profile1
            )
        )
        gmailList.add(
            Gmail(
                "Jane Smith",
                "Subject 2",
                "Short message preview",
                "This is the full message body.",
                "9:00 AM",
                R.drawable.profile2
            )
        )

        gmailList.add(
            Gmail(
                "Alice Johnson",
                "Subject 3",
                "Short message preview 3",
                "This is the full message body for email 3.",
                "1:15 PM",
                R.drawable.profile3
            )
        )
        gmailList.add(
            Gmail(
                "Bob Brown",
                "Subject 4",
                "Short message preview 4",
                "This is the full message body for email 4.",
                "2:45 PM",
                R.drawable.profile4
            )
        )
        gmailList.add(
            Gmail(
                "Charlie Davis",
                "Subject 5",
                "Short message preview 5",
                "This is the full message body for email 5.",
                "11:00 AM",
                R.drawable.profile5
            )
        )
        gmailList.add(
            Gmail(
                "Diana Garcia",
                "Subject 6",
                "Short message preview 6",
                "This is the full message body for email 6.",
                "8:30 AM",
                R.drawable.profile6
            )
        )
        gmailList.add(
            Gmail(
                "Evan Harris",
                "Subject 7",
                "Short message preview 7",
                "This is the full message body for email 7.",
                "3:20 PM",
                R.drawable.profile7
            )
        )
        gmailList.add(
            Gmail(
                "Fiona Lee",
                "Subject 8",
                "Short message preview 8",
                "This is the full message body for email 8.",
                "6:45 AM",
                R.drawable.profile8
            )
        )
        gmailList.add(
            Gmail(
                "George Miller",
                "Subject 9",
                "Short message preview 9",
                "This is the full message body for email 9.",
                "12:10 PM",
                R.drawable.profile9
            )
        )
        gmailList.add(
            Gmail(
                "Hannah Nelson",
                "Subject 10",
                "Short message preview 10",
                "This is the full message body for email 10.",
                "4:30 PM",
                R.drawable.profile10
            )
        )
        gmailList.add(
            Gmail(
                "Ian O'Connor",
                "Subject 11",
                "Short message preview 11",
                "This is the full message body for email 11.",
                "7:50 AM",
                R.drawable.profile11
            )
        )
        gmailList.add(
            Gmail(
                "Julia Perez",
                "Subject 12",
                "Short message preview 12",
                "This is the full message body for email 12.",
                "5:25 PM",
                R.drawable.profile12
            )
        )
        gmailList.add(
            Gmail(
                "Kevin Quinn",
                "Subject 13",
                "Short message preview 13",
                "This is the full message body for email 13.",
                "10:05 AM",
                R.drawable.profile13
            )
        )
        gmailList.add(
            Gmail(
                "Laura Roberts",
                "Subject 14",
                "Short message preview 14",
                "This is the full message body for email 14.",
                "9:15 AM",
                R.drawable.profile14
            )
        )
        gmailList.add(
            Gmail(
                "Michael Scott",
                "Subject 15",
                "Short message preview 15",
                "This is the full message body for email 15.",
                "2:35 PM",
                R.drawable.profile15
            )
        )
        gmailList.add(
            Gmail(
                "Nina Taylor",
                "Subject 16",
                "Short message preview 16",
                "This is the full message body for email 16.",
                "11:40 AM",
                R.drawable.profile16
            )
        )
        gmailList.add(
            Gmail(
                "Oliver Upton",
                "Subject 17",
                "Short message preview 17",
                "This is the full message body for email 17.",
                "8:00 AM",
                R.drawable.profile17
            )
        )
        gmailList.add(
            Gmail(
                "Paula Vega",
                "Subject 18",
                "Short message preview 18",
                "This is the full message body for email 18.",
                "3:55 PM",
                R.drawable.profile18
            )
        )
        gmailList.add(
            Gmail(
                "Quincy White",
                "Subject 19",
                "Short message preview 19",
                "This is the full message body for email 19.",
                "7:10 AM",
                R.drawable.profile19
            )
        )
        gmailList.add(
            Gmail(
                "Rachel Young",
                "Subject 20",
                "Short message preview 20",
                "This is the full message body for email 20.",
                "6:00 PM",
                R.drawable.profile20
            )
        )



    }


    private fun sortListByNewest() {
        gmailList.sortByDescending { it.date }
        adapter.notifyDataSetChanged()
    }


    private fun sortListByOldest() {
        gmailList.sortBy { it.date }
        adapter.notifyDataSetChanged()
    }


}
