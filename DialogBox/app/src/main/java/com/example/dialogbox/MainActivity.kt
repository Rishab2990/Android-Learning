package com.example.dialogbox

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import com.example.dialogbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {


            val builder = AlertDialog.Builder(this)
            builder.setTitle("Are You Sure")
            builder.setMessage("Do you want to Close the app")
            builder.setIcon(R.drawable.baseline_add_alert_24)
            builder.setPositiveButton("yes" , DialogInterface.OnClickListener { dialog, which ->
                // What action should be performed when yes clicked ?
                finish()
            })
            builder.setNegativeButton("No" , DialogInterface.OnClickListener{dialog, which ->
                // What kind of action should be performed when user click NO ?
            })
            builder.show()
        }

        binding.btn2.setOnClickListener {
            val language = arrayOf("c++" , "java" , "python" , "kotlin" , "go")
            val builder2 = AlertDialog.Builder(this)
               builder2.setTitle("what is your favourite language")
               builder2.setSingleChoiceItems(language , 0 , DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this, "you click on ${language[which]} " ,Toast.LENGTH_SHORT).show()
                })
            builder2.setPositiveButton("Yes" , DialogInterface.OnClickListener { dialog, which ->

               Toast.makeText(this, "Accept" , Toast.LENGTH_SHORT).show()
            })
            builder2.setNegativeButton("No" , DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "You don't choose nothing" , Toast.LENGTH_SHORT).show()
            })
            builder2.show()
        }
    }
}


