package com.example.diceroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class num_dice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_num_dice)



        val btn_backlunch:Button=findViewById(R.id.btn_back_lunche)
        btn_backlunch.setOnClickListener {
            val intent = Intent(this, start::class.java)
            // start your next activity
            startActivity(intent)
        }

        val btn_next:Button=findViewById(R.id.btn_next)
        btn_next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // start your next activity
            startActivity(intent)
        })




    }
}