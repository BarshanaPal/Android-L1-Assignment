package com.wipro.topic6_assignment1


import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.security.AccessController.getContext


class MyService:Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        Log.d("TAG", "Service created")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Handler().postDelayed(
            {for (i in 0..10000){
                Log.d("TAG", "Service is running $i")  }
            },
            2000)
         return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d("TAG", "Service Destroyed")
        super.onDestroy()
    }
}