package com.wipro.topic2_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Show a toast on your screen while launching your application
        Toast.makeText(this,"Application launched",Toast.LENGTH_LONG).show()

        //Add a button in hello world program. When button is clicked show a Toast notification that button is clicked
        //Initialize variable
        button=findViewById(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this,"Button is clicked",Toast.LENGTH_LONG).show()
            val intent=Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }
}