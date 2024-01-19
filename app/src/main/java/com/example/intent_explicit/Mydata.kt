package com.example.intent_explicit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Mydata : AppCompatActivity(), View.OnClickListener {
    companion object const  {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_TELP = "extra_telp"
        const val EXTRA_ALAMAT = "extra_alamat"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mydata)

        val Result : TextView = findViewById(R.id.tv_data_received1)
        val Name : String? = intent.getStringExtra(EXTRA_NAME)
        val age :Int = intent.getIntExtra(EXTRA_AGE, 0)
        val telp: String? = intent.getStringExtra(EXTRA_TELP)
        val alamat: String? = intent.getStringExtra(EXTRA_ALAMAT)

        val text: String = "name : $Name\nYour age : $age\ntelp :$telp "
        Result.setText(text).toString()

        val back :Button = findViewById(R.id.btn_move_activity_data2)
        back.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null){
            when(v.id ){
                R.id.btn_move_activity_data2 ->{
                    val move = Intent(this@Mydata , MainActivity::class.java)
                    startActivity(move)
                }
            }
        }
    }

}