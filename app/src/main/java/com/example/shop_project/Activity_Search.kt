package com.example.shop_project

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Activity_Search : AppCompatActivity() {

    private lateinit var itemsList: RecyclerView
    private lateinit var items: ArrayList<Categories>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)

        itemsList = findViewById(R.id.categories_list)
        categoryInformation()

        setClickListener(R.id.icon_main, MainMenu_Activity::class.java)
        setClickListener(R.id.icon_korzina, Activity_Basket::class.java)
        setClickListener(R.id.icon_profile, Activity_Profile::class.java)

    }
    private fun categoryInformation() {
        items = arrayListOf(
            Categories("headphones", "Наушники", "Logitech, Razer, HyperX,\n" +
                    " SteelSeries, Bloody, Corsair"),
            Categories("mouse", "Мышки", "Logitech, Razer, HyperX,\n" +
                    " SteelSeries, Bloody, A4Tech"),
            Categories("microphone", "Микрофоны", "Logitech, Razer, HyperX,\n" +
                    " Fifine, Bloody, Samsung, Blue Yeti"),
            Categories("keyboard", "Клавиатуры", "Logitech, SVEN, HyperX,\n" +
                    " Steelseries, Bloody, ASUS"),
            Categories("carpet", "Коврики", "Logitech, Onikuma, HARPER,\n" +
                    " Red Square, Xiaomi, A4Tech")
        )
        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }

    private fun setClickListener(imageViewId: Int, targetActivity: Class<*>) {
        val imageView: ImageView = findViewById(imageViewId)
        imageView.setOnClickListener {
            try {
                val intent = Intent(this, targetActivity)
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}