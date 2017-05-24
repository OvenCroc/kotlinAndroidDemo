package com.example.tmp246.myapplication

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import com.example.tmp246.myapplication.entity.Computer
import com.example.tmp246.myapplication.request.Request
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val computer: Computer = Computer(Date(), "acer")
    val computer2 = computer.copy(productor = "lenovo")


    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv1.text = "1111111111111111"
        tv1.onClick {
            createDialogView()
        }
    }

    override fun onResume() {
        super.onResume()
        async {
            Request("http://192.168.28.57:8089/yjs-app-monitor-web/verison/check")
                    .doRequest()
        }
        createDialogView()
    }

    fun createDialogView() {
        val dialog: Dialog = Dialog(activity_main_rl.context, R.style.AppTheme)
        dialog.setContentView(activity_main_rl.context.linearLayout {
            this.gravity = Gravity.CENTER
            this.orientation = LinearLayout.HORIZONTAL
            this.backgroundColor = Color.parseColor("#000fff")
            this.alpha = 1f
            textView {
                this.text = "我是dialog里面的text"
                this.textColor = Color.parseColor("#ff00ff")
                this.backgroundColor = Color.parseColor("#ffffff")
                onClick {
                    Log.i("zp", "click now")
                    dialog.dismiss()
                }
            }
            textView {
                text = "text2"
                textColor = Color.parseColor("#fff000")
                onLongClick {
                    Log.i("zp", "onlongclick")
                    false
                }
            }
        })
        dialog.show()
    }
}
