 package com.example.customizedalertbox

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


 class MainActivity : AppCompatActivity() {
 private lateinit var dialog:Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)
      dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alertbox))


        // creating variable for custom  dialog.xml design

        val feedback = dialog.findViewById<Button>(R.id.btnfeedback)
        val btn2 = dialog.findViewById<Button>(R.id.btngood)

        btn2.setOnClickListener {
            dialog.dismiss()

        }
        feedback.setOnClickListener {
        Toast.makeText(this, "clicked on feedback" , Toast.LENGTH_SHORT).show()
        }
        button.setOnClickListener {
            dialog.show()
        }

    }
}