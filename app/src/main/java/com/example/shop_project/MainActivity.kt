package com.example.shop_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.link_reg)
        textView.setOnClickListener {
            try{
                val intent = Intent(this, Registration_Activity::class.java)
                startActivity(intent)
            }
            catch (e: Exception){
                e.printStackTrace()
            }
        }
        val start: Button= findViewById(R.id.btn_enter)
        start.setOnClickListener{
            try{
                val intent = Intent(this, MainMenu_Activity::class.java)
                startActivity(intent)
                finish()
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}