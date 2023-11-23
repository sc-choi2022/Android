package com.controlflowwhile

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var current = 1
        val until = 12
        while (current < until){
            Log.d("while", "현재 값은 ${current}")
            current = current + 1
        }

        var game = 1
        val match = 6
        do {
            Log.d("while", "${game}게임 이겼다. 우승까지 ${match-game} 남았다.")
            game += 1
        } while (game < match)
    }
}