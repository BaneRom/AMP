package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animals= arrayOf<String>("Tiger","Cheetah","Jaguar","Leopard","Lion","Elephant","Bear","Dog","Cat","Otter")
        val listview=findViewById<ListView>(R.id.mylist)
        listview.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,animals)
        listview.setOnItemClickListener { adapterView, view, i, l ->
            val toast=Toast.makeText(this,"You clicked on the animal\n"+animals[i],Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }
    }
}