package com.example.diceroll

import android.media.AudioManager

import android.media.SoundPool


object PreLollipopSoundPool {
    fun NewSoundPool(): SoundPool {
        return SoundPool(1, AudioManager.STREAM_MUSIC, 0)
    }
}