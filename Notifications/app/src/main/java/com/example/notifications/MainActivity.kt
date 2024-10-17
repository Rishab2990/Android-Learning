package com.example.notifications

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val CHANNEL_ID = "channelId"
    val CHANNEL_NAME = "channelName"
    val  NotificationId = 0

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val notify = findViewById<Button>(R.id.notification)

        createNotificationChannel()

        // pending Intent
        val intent = Intent(this , MainActivity::class.java)
        val pendingIntent =  PendingIntent.getActivities(this,0, arrayOf(intent), PendingIntent.FLAG_MUTABLE)

        var notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.notifications)
            .setContentTitle("Notification Practice app")
            .setContentText("I learn notification topic through tutorial")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .build()


        val notificationManager =NotificationManagerCompat.from(this)
        notify.setOnClickListener {

            notificationManager.notify(NotificationId,notification)
        }
    }



        private fun createNotificationChannel(){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME , NotificationManager.IMPORTANCE_DEFAULT).apply {
                    description = "This is Notification practice app"
                    enableLights(true)
                    lightColor = Color.RED
                }

                val notificationManger = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManger.createNotificationChannel(channel)


            }        }

}