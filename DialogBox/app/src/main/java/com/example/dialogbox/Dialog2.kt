package com.example.dialogbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dialogbox.databinding.ActivityMainBinding


class Dialog2 : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}