package com.example.diceroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val text_view:TextView =findViewById(R.id.name_game)
        val image_logo:ImageView=findViewById(R.id.dice_image_logo)
        val play_btn:Button=findViewById(R.id.btn_play)

        play_btn.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, num_dice::class.java)
            // start your next activity
            startActivity(intent)


        })

    }
}