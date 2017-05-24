package com.example.tmp246.myapplication.request

import android.util.Log
import java.net.URL

/**
 * Created by TMP246 on 2017/5/24.
 */
class Request(val url: String) {

    fun doRequest() {
        val jsonStr = URL(url).readText()
        Log.i("zp", jsonStr)
    }
}