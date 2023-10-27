package com.example.audio

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val seekBar = findViewById<SeekBar>(R.id.seekbar)
        val btnrestart = findViewById<Button>(R.id.stop)
        val btnplay = findViewById<Button>(R.id.play)
        val btnpause = findViewById<Button>(R.id.pause)
        val volume = findViewById<SeekBar>(R.id.sound)

        val mediaPlayer1 = MediaPlayer.create(this, R.raw.unstoppable)
        val totalTime = mediaPlayer1.duration
        mediaPlayer1.start()
        val uri = Uri.parse("android.resource://${packageName.lowercase(Locale.ROOT)}/raw/unstoppable")
        MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA).build()
            )
            setDataSource(this@MainActivity, uri)
        }
        btnplay.setOnClickListener {
            mediaPlayer1.start()
        }
        btnpause.setOnClickListener {
            mediaPlayer1.pause()
        }
        btnrestart.setOnClickListener {
          mediaPlayer1.stop()
            mediaPlayer1.prepare()
            mediaPlayer1.start()
        }
        // WHEN USER CHANGE THE TIME STAMP OF MUSIC, REFLECT THE CHANGES
        seekBar.max = totalTime
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                (if (fromUser) {
                    mediaPlayer1.seekTo(progress)
                })
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                if (mediaPlayer1.isPlaying) {
                    seekBar.progress = mediaPlayer1.currentPosition
                    handler.postDelayed(this, 1000)
                }
            }
        }, 0)

        //  initialize audioManager
        val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        // set max volume
        volume.max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        // check the current volume
        volume.progress = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        volume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    audioManager.setStreamVolume(
                        AudioManager.STREAM_MUSIC, progress, AudioManager.FLAG_SHOW_UI
                    )
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })



    }
}





