package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {

    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 =  findViewById<Button>(R.id.button)
        val name = findViewById<EditText>(R.id.name)
        val phone = findViewById<EditText>(R.id.Phone)
        val mail = findViewById<EditText>(R.id.mailAddress)
        val password = findViewById<EditText>(R.id.Password)
        val id = findViewById<EditText>(R.id.unique)


        button1.setOnClickListener {
            val name = name.text.toString()
            val phone = phone.text.toString().toInt()
            val mail = mail.text.toString()
            val password = password.text.toString()
            val uniqueId = id.text.toString()

            val users =Users(name,phone,mail,password,uniqueId)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(uniqueId).setValue(users).addOnSuccessListener {
                Toast.makeText(this,"Users Registered" , Toast.LENGTH_LONG).show()
            }.addOnSuccessListener {
                Toast.makeText(this , "Failed" , Toast.LENGTH_LONG).show()
            }
        }

    }
}