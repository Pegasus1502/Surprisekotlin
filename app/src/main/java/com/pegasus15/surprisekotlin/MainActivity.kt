package com.pegasus15.surprisekotlin

import android.content.Intent

import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var getName: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ContextCompat.getColor(this, R.color.status).also { window.statusBarColor = it }
        getName = findViewById(R.id.getName)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            if(getName.text.toString().trim().isEmpty())
                 {
                     Toast.makeText(applicationContext, "Please Enter Your Name!!!", Toast.LENGTH_LONG).show()

            } else {

                sendData()
            }
        }


    }

    private fun sendData() {
        val intent = Intent(this@MainActivity, WishesActivity::class.java)
        val message = getName.text.toString()
        intent.putExtra("message_key", message)
        startActivity(intent)
        finish()
    }
}