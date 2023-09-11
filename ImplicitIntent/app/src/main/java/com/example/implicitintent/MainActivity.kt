package com.example.implicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dial = findViewById<Button>(R.id.dial)
        findViewById<Button>(R.id.share)
        findViewById<Button>(R.id.message)
        findViewById<Button>(R.id.email)

       dial.setOnClickListener {
          val  dialer =  Intent(Intent.ACTION_DIAL)
           dialer.data = Uri.parse("tel: 8882225126")
           startActivity(dialer)
       }
    }
}


