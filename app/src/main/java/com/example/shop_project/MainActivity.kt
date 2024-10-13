package com.example.shop_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.w3c.dom.Text
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {
    private lateinit var dialog: BottomSheetDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val settings: TextView = findViewById(R.id.link_pass)
        settings.setOnClickListener {
            showSheet(R.layout.password_recovery)
        }

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
    private fun showSheet(idDialog: Int) {
        dialog = BottomSheetDialog(this)
        dialog.setContentView(idDialog)
        closureSheet(R.id.link_remembered)
        dialog.show()
    }
    private fun closureSheet(idDialog: Int){
        val backSheet: TextView = dialog.findViewById(idDialog)!!
        backSheet.setOnClickListener {
            dialog.dismiss()
        }
    }
}