package com.wipro.topic4_assignment1

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {
    private lateinit var next:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        next=findViewById(R.id.nextButton)
        nextButton.setOnClickListener{
           val intent=packageManager.getLaunchIntentForPackage("com.wipro.topic4_assignment1_b")
            if(intent!=null){
                startActivity(intent)
            }else
            {
                Toast.makeText(this,"There is no package in android",Toast.LENGTH_LONG).show()
            }
    }
}
}