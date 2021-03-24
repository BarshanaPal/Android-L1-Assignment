package com.wipro.topic5_assignment1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var email:EditText
    private lateinit var mobile:EditText
    private lateinit var city:EditText
    private lateinit var saveButton:Button
    private lateinit var killActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name_editText)
        email = findViewById(R.id.email_editText)
        mobile = findViewById(R.id.mobile_editText)
        city = findViewById(R.id.city_editText)
        saveButton = findViewById(R.id.saveData)
        killActivityButton=findViewById(R.id.killActivity)

        retrieveData()

        saveButton.setOnClickListener {
          saveEntry()
        }
        killActivityButton.setOnClickListener {
            finish()
        }
    }

    private fun saveEntry() {
        if(name.text.isEmpty()){
            name.error="Please enter your name"
        }else if(email.text.isEmpty()){
            email.error="Please enter your email"
        }else if(mobile.text.isEmpty()){
            mobile.error="Please enter your mobile-no"
        }else if(city.text.isEmpty()){
            city.error="Please enter city"
        }else{
            val sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()
            editor.putString("nameKey",name.text.toString())
            editor.putString("emailKey",email.text.toString())
            editor.putString("mobileKey",mobile.text.toString())
            editor.putString("cityKey",city.text.toString())

            editor.apply()
            Toast.makeText(this,"Data Saved Successfully",Toast.LENGTH_LONG).show()
        }
    }
    private fun retrieveData() {
        val sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val uName=sharedPreferences.getString("nameKey","")
        val emailId=sharedPreferences.getString("emailKey","")
        val mobileNo=sharedPreferences.getString("mobileKey","")
        val cityName=sharedPreferences.getString("cityKey","")

        name.setText(uName)
        email.setText(emailId)
        mobile.setText(mobileNo)
        city.setText(cityName)

    }
}