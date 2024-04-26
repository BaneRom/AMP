package com.example.broadcastreceiver

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = c.activeNetworkInfo

        if (networkInfo!= null && networkInfo.isConnected)
        {
            if (networkInfo.type==ConnectivityManager.TYPE_MOBILE)
            {
                Toast.makeText(applicationContext,"Connected to Mobile", Toast.LENGTH_LONG).show()
            }
            if (networkInfo.type==ConnectivityManager.TYPE_WIFI)
            {
                Toast.makeText(applicationContext, "Connected to Wifi", Toast.LENGTH_LONG).show()
            }
        }
        else
        {
            Toast.makeText(applicationContext, "You are Offline", Toast.LENGTH_LONG).show()
        }
    }
}