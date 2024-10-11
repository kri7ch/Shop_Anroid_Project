package com.example.shop_project

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        setClickListener(R.id.icon_search, Activity_Search::class.java)
        setClickListener(R.id.icon_main, MainMenu_Activity::class.java)
        setClickListener(R.id.icon_korzina, Activity_Basket::class.java)

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