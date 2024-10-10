package com.example.shop_project

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registration_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)

        val textView: TextView = findViewById(R.id.link_enter)
        textView.setOnClickListener {
            try{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}