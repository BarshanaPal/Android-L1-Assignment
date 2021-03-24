package com.wipro.topic4_assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var nextActivity: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextActivity=findViewById(R.id.next)
        nextActivity.setOnClickListener{
            startActivity(Intent(this,SecondActivity::class.java))
        }

    }
}