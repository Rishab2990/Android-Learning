package com.example.taskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView


class TaskManager2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_manager2)

        val text = findViewById<EditText>(R.id.edittext)
        val addbutton = findViewById<Button>(R.id.button)
        val listview = findViewById<ListView>(R.id.listview)


        val savedData = arrayListOf<String>()
        addbutton.setOnClickListener {
            val savedText = text.text.toString()
            if (savedText.isNotEmpty()) {
                savedData.add(savedText)
            }
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, savedData)
            listview.adapter = adapter
            text.text.clear()
        }


    }





}







