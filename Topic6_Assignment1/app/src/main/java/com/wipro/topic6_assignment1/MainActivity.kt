package com.wipro.topic6_assignment1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun startService(v: View?) {
        val serviceIntent = Intent(this, MyService::class.java)
        startService(serviceIntent)
        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show()
    }

    fun stopService(v: View?) {
        val serviceIntent = Intent(this, MyService::class.java)
        stopService(serviceIntent)
        Toast.makeText(this,"Service Stoped",Toast.LENGTH_LONG).show()
    }
}
