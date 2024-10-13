package com.example.shop_project

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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

        val textView: TextView = findViewById(R.id.log_out)
        textView.setOnClickListener {
            showLogOutDialog(MainActivity::class.java)
        }
    }

    private fun showLogOutDialog(targetActivity: Class<*>) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.log_out_title)
        builder.setMessage(R.string.log_out_message)
        builder.setNegativeButton("Да") { dialog, id ->
            logOutAccount(targetActivity)
            dialog.dismiss()
        }
        builder.setPositiveButton("Нет") { dialog, id ->
            dialog.cancel()
        }
        val alert = builder.create()
        alert.show()
    }

    private fun logOutAccount(targetActivity: Class<*>) {
        val intent = Intent(this, targetActivity)
        startActivity(intent)
        finish()
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