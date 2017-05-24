package com.example.tmp246.myapplication.entity

import android.util.Log
import java.util.*

/**
 * Created by TMP246 on 2017/5/24.
 */
data class Computer(val productDate: Date, val productor: String) {
    var price: Double = 0.0

    init {
        Log.i("zp", "productor " + productor)
    }
}