package com.example.gmailapp.adapter

import Gmail
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.gmailapp.R

class GmailAdapter(private val context: Context, private val gmailList: List<Gmail>) : BaseAdapter() {

    override fun getCount(): Int = gmailList.size

    override fun getItem(position: Int): Any = gmailList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)

        val gmail = gmailList[position]

        val senderImage: ImageView = view.findViewById(R.id.sender_image)
        val senderName: TextView = view.findViewById(R.id.sender_name)
        val subject: TextView = view.findViewById(R.id.subject)
        val shortMessage: TextView = view.findViewById(R.id.short_message)
        val date: TextView = view.findViewById(R.id.date)
        val starIcon: ImageView = view.findViewById(R.id.star_icon)

        senderImage.setImageResource(gmail.profileImageResource)
        senderName.text = gmail.senderName
        subject.text = gmail.subject
        shortMessage.text = gmail.shortMessage
        date.text = gmail.date

        return view
    }
}
