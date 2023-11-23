package com.example.controlflow1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ball = 4
        if (ball > 3){
            Log.d("ControlFlow", "4볼로 출루합니다.")
        } else {
            Log.d("ControlFlow", "타석에서 다음 타구를 기다립니다.")
        }

        var a = 1
        var b = 2
        var c = 3

        // 1. if문 두 번 사용하기
        if (a < b) {
            Log.d("ControlFlow", "1: a는 b보다 작습니다.")
        }
        if (a < c) {
            Log.d("ControlFlow", "1: a는 c보다 작습니다.")
        }

        // 2. else if 문 사용하기
        if (a < b) {
            Log.d("ControlFlow", "2: a는 b보다 작습니다.")
        } else if (a < c){
            Log.d("ControlFlow", "2: a는 c보다 작습니다.")
        }


        // 변수에 직접 if문 사용해보기
        var eraOfRyu = 2.32
        var eraOfDegrom = 2.43

        val era = if (eraOfRyu > eraOfDegrom) {
            Log.d("MLB_Result", "2019 류현진이 디그룸을 이겼습니다.")
            eraOfRyu
        } else {
            Log.d("MLB_Result", "2019 디그룸이 류현진을 이겼습니다.")
            eraOfDegrom
        }

        Log.d("MLB_Result", "2019 MLB에서 가장 높은 ERA는 ${era}입니다.")

        // when
//        var now = 10
//        when (now) {
//            8 -> {
//                Log.d("when", "현재 시간은 8시입니다.")
//            }
//            9 -> {
//                Log.d("when", "현재 시간은 9시입니다.")
//            }
//            else -> {
//                Log.d("when", "현재 시간은 9시가 아닙니다.")
//            }
//        }

        // when 콤마로 구분해서 사용하기
        var now = 9
        when (now) {
            8, 9 -> {
                Log.d("when", "현재 시간은 8시 또는 9시입니다.")
            }
            else -> {
                Log.d("when", "현재 시간은 9시가 아닙니다.")
            }
        }

        var ageOfMichael = 19
        when (ageOfMichael){
            in 10..19 -> {
                Log.d("when", "마이클은 10대이다.")
            }
            !in 10..19 -> {
                Log.d("when", "마이클은 10대가 아니다.")
            }
            else -> {
                Log.d("when", "마이클의 나이를 알 수 없다.")
            }
        }

        // 파라미터가 없는 when 사용하기
        var currentTime = 6
        when {
            currentTime == 5 -> {
                Log.d("when", "현재 시간은 5시이다.")
            }
            currentTime > 5 -> {
                Log.d("when", "현재 시간은 5시가 넘었다.")
            }
            else -> {
                Log.d("when", "현재 시간은 5시 이전이다.")
            }
        }
    }
}