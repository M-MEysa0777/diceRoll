package com.example.diceroll


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    val randomInt= kotlin.random.Random.nextInt(6)+1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnroll:Button =findViewById(R.id.btn_roll)
        btnroll.setOnClickListener{
            rollDice()
            rollDice2()
        }
    }

    private fun rollDice() {


        val drawbleResource=when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val diceImage:ImageView=findViewById(R.id.dice_image)
        diceImage.setImageResource(drawbleResource)
    }

    private fun rollDice2() {
        val drawablesResource=when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val diceImage2:ImageView=findViewById(R.id.dice_image2)
        diceImage2.setImageResource(drawablesResource)

    }

}