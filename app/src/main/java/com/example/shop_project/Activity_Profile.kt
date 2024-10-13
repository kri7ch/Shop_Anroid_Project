package com.example.shop_project

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetDialog

class Activity_Profile : AppCompatActivity() {
    private lateinit var dialog: BottomSheetDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        setClickListener(R.id.icon_search, Activity_Search::class.java)
        setClickListener(R.id.icon_main, MainMenu_Activity::class.java)
        setClickListener(R.id.icon_korzina, Activity_Basket::class.java)

        val close: TextView = findViewById(R.id.log_out)
        close.setOnClickListener {
            showLogOutDialog(MainActivity::class.java)
        }

        val order: TextView = findViewById(R.id.link_orders)
        order.setOnClickListener {
            showSheet(R.layout.order_sheet)
        }

        val sendMessage: TextView = findViewById(R.id.link_support)
        sendMessage.setOnClickListener {
            showSheet(R.layout.support_sheet)
        }

    }

    private fun showSheet(imageViewId: Int) {
        dialog = BottomSheetDialog(this)
        dialog.setContentView(imageViewId)
        closureSheet(R.id.icon_back)
        dialog.show()
    }

    private fun closureSheet(imageViewId: Int){
        val backOrder: ImageView = dialog.findViewById(imageViewId)!!
        backOrder.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun showLogOutDialog(targetActivity: Class<*>) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.log_out_title)
        builder.setMessage(R.string.log_out_message)
        builder.setNegativeButton("Да") { dialog, _ ->
            logOutAccount(targetActivity)
            dialog.dismiss()
        }
        builder.setPositiveButton("Нет") { dialog, _ ->
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