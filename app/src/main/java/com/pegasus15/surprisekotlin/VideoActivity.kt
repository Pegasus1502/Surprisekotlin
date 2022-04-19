package com.pegasus15.surprisekotlin


import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class VideoActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        ContextCompat.getColor(this, R.color.status).also { window.statusBarColor = it }

        vPlay()
    }

    private fun vPlay(){

        videoView = findViewById(R.id.videoView)
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video)
        videoView.setVideoURI(uri)
        videoView.start()

        videoView.setOnCompletionListener {
            Toast.makeText(this@VideoActivity, "Enjoy Your Day!!!", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}