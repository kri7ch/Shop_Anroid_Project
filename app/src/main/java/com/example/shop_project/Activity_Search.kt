package com.example.shop_project

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Activity_Search : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)

        val itemsList: RecyclerView = findViewById(R.id.categories_list)
        val items = arrayListOf<Categories>()

        items.add(Categories("headphones", "Наушники", "Logitech, Razer, HyperX,\n" +
                " SteelSeries, Bloody, JBL, Corsair"))
        items.add(Categories("mouse", "Мышки", "Logitech, Razer, HyperX,\n" +
                " SteelSeries, Bloody, A4Tech"))
        items.add(Categories("microphone", "Микрофоны", "Logitech, Razer, HyperX,\n" +
                " Fifine, Bloody, Samsung, Blue Yeti"))
        items.add(Categories("keyboard", "Клавиатуры", "Logitech, SVEN, HyperX,\n" +
                " Steelseries, Bloody, ASUS"))
        items.add(Categories("carpet", "Коврики", "Logitech, Onikuma, HARPER,\n" +
                " Red Square, Xiaomi, A4Tech"))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)

        val imageView: ImageView = findViewById(R.id.icon_main)
        imageView.setOnClickListener {
            try{
                val intent = Intent(this, MainMenu_Activity::class.java)
                startActivity(intent)
            }
            catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}