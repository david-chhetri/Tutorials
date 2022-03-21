package com.dhan.countersocket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterBtn = findViewById<Button>(R.id.counterBtn)
        val countTextView = findViewById<TextView>(R.id.countTextView)

        SocketHandler.setSocket()
        val mSocket = SocketHandler.getSocket()

        mSocket.connect()



        counterBtn.setOnClickListener{

            mSocket.emit("counter")
            //countTextView.text = counter.toString()
        }

        mSocket.on("counter"){args ->
            if (args[0] != null){
                val counter = args[0] as Int

                runOnUiThread{
                    countTextView.text = counter.toString()
                }
            }
        }
    }
}