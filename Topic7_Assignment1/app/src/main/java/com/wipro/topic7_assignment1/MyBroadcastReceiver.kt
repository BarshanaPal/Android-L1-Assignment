package com.wipro.topic7_assignment1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyBroadcastReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("TAG", "----BootReceiver---")

        if (intent!!.action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            Log.e("TAG", "----BOOT_COMPLETED---")
            val intent2 = Intent(context, MainActivity::class.java)
            intent2.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context!!.startActivity(intent2)
        }
    }
}