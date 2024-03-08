package com.example.wishlist

import WishlistAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val wishlistItems = mutableListOf<WishlistItem>()
    private lateinit var addButton : Button
    private lateinit var nameEditText : EditText
    private lateinit var linkEditText : EditText
    private lateinit var priceEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = wishlistItems
        data.add(WishlistItem("Sample Item", "https://samplelinklives.here", "$0.01"))

        val adapter = WishlistAdapter(data)
        recyclerView.adapter = adapter

        addButton = findViewById(R.id.addButton)
        nameEditText = findViewById(R.id.nameEditText)
        linkEditText = findViewById(R.id.linkEditText)
        priceEditText = findViewById(R.id.priceEditText)

        addButton.setOnClickListener{
            if (nameEditText.text.isNotEmpty() && linkEditText.text.isNotEmpty() && priceEditText.text.isNotEmpty()) {
                val name = nameEditText.text.toString()
                val link = linkEditText.text.toString()
                val price = "$" + priceEditText.text.toString()

                val newItem = WishlistItem(name, link, price)
                wishlistItems.add(newItem)
                adapter.notifyDataSetChanged()

                // Clear EditText fields
                nameEditText.text.clear()
                linkEditText.text.clear()
                priceEditText.text.clear()
            } else {
                Toast.makeText(this@MainActivity, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
