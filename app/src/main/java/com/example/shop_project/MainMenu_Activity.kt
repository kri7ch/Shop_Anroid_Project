package com.example.shop_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainMenu_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_menu)

        val imageView: ImageView = findViewById(R.id.icon_search)
        imageView.setOnClickListener {
            try{
                val intent = Intent(this, Activity_Search::class.java)
                startActivity(intent)
            }
            catch (e: Exception){
                e.printStackTrace()
            }
        }

    }
}