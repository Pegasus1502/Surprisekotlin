package com.pegasus15.surprisekotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class WishesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishes)
        ContextCompat.getColor(this, R.color.first).also { window.statusBarColor = it }

        val secondsDelayed = 1
        Handler().postDelayed({
            startActivity(Intent(this@WishesActivity, VideoActivity::class.java))
            finish()
        }, (secondsDelayed * 3000).toLong())
        hello()

    }


    @SuppressLint("SetTextI18n")
    private fun hello(){
        val message = intent.getStringExtra("message_key")
        val messageTextView: TextView = findViewById(R.id.nameShow)
        messageTextView.text  = (" $message! ")
    }
}