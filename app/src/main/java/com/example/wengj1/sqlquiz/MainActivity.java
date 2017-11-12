package com.example.wengj1.sqlquiz

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var play: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        play = findViewById<View>(R.id.play) as Button
        play!!.setOnClickListener {
            val intent = Intent(this@MainActivity, Categories::class.java)
            startActivity(intent)
        }
    }
}
