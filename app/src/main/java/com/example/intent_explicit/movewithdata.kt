package com.example.intent_explicit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class movewithdata : AppCompatActivity() ,View.OnClickListener{
    companion object const  {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movewithdata)

        val textresutl :TextView = findViewById(R.id.tv_data_received)
        val name: String? = intent.getStringExtra(EXTRA_NAME)
        val age: Int = intent.getIntExtra(EXTRA_AGE, 0)

        val text: String = "name : $name\nYour age : $age"
        textresutl.setText(text).toString()

        val back :Button = findViewById(R.id.btn_move_activity_data2)
        back.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.btn_move_activity_data2 ->{
                    val moveintent = Intent(this@movewithdata, MainActivity::class.java)
                    startActivity(moveintent)
                }
            }
        }
    }

}