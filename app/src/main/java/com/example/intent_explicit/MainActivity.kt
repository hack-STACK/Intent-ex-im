package com.example.intent_explicit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var text :EditText
    private lateinit var age :EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonmoveact :Button = findViewById(R.id.btn_move_activity_data)
        val button :Button = findViewById(R.id.btn_move_activity)
        val buttondial :Button = findViewById(R.id.btn_dial_number)
        text = findViewById(R.id.editTextUserInput)
        age = findViewById(R.id.editTextUserInput2)
        button.setOnClickListener(this)
        buttonmoveact.setOnClickListener(this)
        buttondial.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.btn_move_activity ->{
                    val moveintent = Intent(this@MainActivity,moveact::class.java)
                    startActivity(moveintent)
                }
                R.id.btn_move_activity_data ->{
                    val moveintent = Intent(this@MainActivity, movewithdata::class.java)

                    val name = text.text.toString()
                    val ageString = age.text.toString()
                    val ageValue = ageString.toIntOrNull()

                    moveintent.putExtra(movewithdata.EXTRA_NAME, name)
                    moveintent.putExtra(movewithdata.EXTRA_AGE, ageValue)


                   startActivity(moveintent)
                }
                R.id.btn_dial_number ->{
                    val numberPhone = "081234047522"
                    val dialphonetesting = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numberPhone"))
                    startActivity(dialphonetesting)
                }

            }
        }
    }
}