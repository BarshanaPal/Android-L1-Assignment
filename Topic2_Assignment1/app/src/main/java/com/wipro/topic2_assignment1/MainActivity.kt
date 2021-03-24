package com.wipro.topic2_assignment1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java 

class MainActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var nextPageButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton=findViewById(R.id.loginButton)
        nextPageButton=findViewById(R.id.nextPage)
        loginButton.setOnClickListener {
            Toast.makeText(this,"Login Button clicked",Toast.LENGTH_LONG).show()
        }
        nextPageButton.setOnClickListener {
            val intent=Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }
}