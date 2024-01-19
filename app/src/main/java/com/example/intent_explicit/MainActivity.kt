package com.example.intent_explicit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var text :EditText
    private lateinit var age :EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonhole :Button = findViewById(R.id.btn_move_activity_data)
        val button :Button = findViewById(R.id.btn_move_activity)
        val `button-dial` :Button = findViewById(R.id.btn_dial_number)
        val mydata :Button = findViewById(R.id.My_data)

        mydata.setOnClickListener(this)
        text = findViewById(R.id.editTextUserInput)
        age = findViewById(R.id.editTextUserInput2)
        button.setOnClickListener(this)
        buttonhole.setOnClickListener(this)
        `button-dial`.setOnClickListener(this)
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
                R.id.My_data ->{
                    val  move = Intent(this@MainActivity, Mydata::class.java)
                    val name = "Juan"
                    val ageString = "20"
                    val telp = "081234047522"
                    val alamat = "pakis"
                    val ageVal = ageString.toIntOrNull()


                    move.putExtra(Mydata.EXTRA_NAME, name)
                    move.putExtra(Mydata.EXTRA_AGE, ageVal)
                    move.putExtra(Mydata.EXTRA_TELP, telp)
                    move.putExtra(Mydata.EXTRA_ALAMAT,alamat)
                    startActivity(move)
                }

            }
        }
    }
}