package com.myapp.cuniwarts.features.housepointscalculator.presentation.utils

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.core.content.ContextCompat.getSystemService

class VibratorHelper(private val context: Context) {

    fun vibrate(duration: Long){
        try {
            val vibrator= getSystemService(context, Vibrator::class.java)
            if(vibrator?.hasVibrator() == true){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
                    val vibrationEffect = VibrationEffect.createOneShot(duration,VibrationEffect.DEFAULT_AMPLITUDE)
                    vibrator.vibrate(vibrationEffect)
                }else{
                    vibrator.vibrate(duration)
                }
            }
        }catch (e: Exception){
            //TODO
        }
    }

}