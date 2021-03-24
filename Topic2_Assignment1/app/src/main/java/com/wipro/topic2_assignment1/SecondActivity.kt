package com.wipro.topic2_assignment1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var login:Button
    private lateinit var next:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        login=findViewById(R.id.login)
        next=findViewById(R.id.next)
        login.setOnClickListener {
            Toast.makeText(this,"Login Button clicked", Toast.LENGTH_LONG).show()
        }
        next.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}