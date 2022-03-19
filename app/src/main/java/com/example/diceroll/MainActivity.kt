package com.example.diceroll


import android.annotation.SuppressLint
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroll.PreLollipopSoundPool.NewSoundPool
import java.util.*


class MainActivity : AppCompatActivity() {

    var randomInt = Random()
    lateinit var dice_sound: SoundPool //For dice sound playing
    var sound_id: Int = 0 //Used to control sound stream return by SoundPool
    lateinit var handler: Handler //Post message to start roll
    val timer = Timer() //Used to implement feedback to user
    var rolling = false //Is die rolling?
    lateinit var rotate: RotateAnimation
    var soundplay: Int = 0
    lateinit var dice_roll:ImageView
    lateinit var sum_txt:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        InitSound()
        dice_roll =findViewById(R.id.dice_image)
        sum_txt =findViewById(R.id.txt_sum)

        val btnroll:Button =findViewById(R.id.btn_roll)
        btnroll.setOnClickListener{
                diceroll()
            if (!rolling){
                rolling=true
                dice_roll.setImageResource(R.drawable.dice3droll)
                soundplay=dice_sound.play(sound_id,1.0f,1.0f,0,0,1.0f)
                dice_roll.startAnimation(rotate)

            }

            }
    }

    private fun diceroll() {
        rotate = RotateAnimation(
            0F,
            360F,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        rotate.duration = 3000
        rotate.interpolator = LinearInterpolator()
        //link handler to callback
        //link handler to callback
        handler = Handler(Handler.Callback {
            when (randomInt.nextInt(6) + 1) {
                1 -> {
                    rotate.cancel()
                    sum_txt.setText("Dice Number : 1")
                    dice_roll.setImageResource(R.drawable.one)
                }
                2 -> {
                    rotate.cancel()
                    sum_txt.setText("Dice Number : 2")
                    dice_roll.setImageResource(R.drawable.two)
                }
                3 -> {
                    rotate.cancel()
                    sum_txt.setText("Dice Number : 3")
                    dice_roll.setImageResource(R.drawable.three)
                }
                4 -> {
                    rotate.cancel()
                    sum_txt.setText("Dice Number : 4")
                    dice_roll.setImageResource(R.drawable.four)
                }
                5 -> {
                    rotate.cancel()
                    sum_txt.setText("Dice Number : 5")
                    dice_roll.setImageResource(R.drawable.five)
                }
                6 -> {
                    rotate.cancel()
                    sum_txt.setText("Dice Number : 6")
                    dice_roll.setImageResource(R.drawable.six)
                }
                else -> {
                }
            }
            rolling = false //user can press again
            true
        }
            //Clean up
        )

    }

    @SuppressLint("ObsoleteSdkInt")
    private fun InitSound() {
        dice_sound = if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            //Use the newer SoundPool.Builder
            //Set the audio attributes, SONIFICATION is for interaction events
            //uses builder pattern
            val aa = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
            SoundPool.Builder().setAudioAttributes(aa).build()
        }else {
            //Running on device earlier than Lollipop
            //Use the older SoundPool constructor
            NewSoundPool()
        }
        sound_id = dice_sound.load(this, R.raw.shake_dice, 1)

        class Roll : TimerTask() {
            override fun run() {
                handler.sendEmptyMessage(0)
            }
        }

    }


}


