package com.function

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 1. 반환값이 있는 함수
        fun square(x: Int): Int {
            return x * x
        }
        // 2. 반환값이 없는 함수
        fun printSum(x: Int, y: Int) {
            Log.d("fun", "x + y = ${x + y}")
        }
        // 3. 입력값 없이 반환값만 있는 함수
        fun getPi() : Double {
            return 3.14
        }
        // 4. 반환값이 있는 함수 square 사용하기
        var squareResult = square(30)
        Log.d("fun", "30의 제곱은 ${squareResult}이다")
        // 5. 반환값이 없는 함수는 그냥 실행
        printSum(3, 5)
        // 6. 입력값이 없는 함수 사용하기
        val PI = getPi()
        Log.d("fun", "지름이 10인 원의 둘레는 ${10 * PI}이다.")
        // 7. 기본값을 갖는 함수
        fun newFunction(name: String, age: Int = 29, weight: Double = 65.5) {
            Log.d("fun", "name의 값은 ${name}이다.")
            Log.d("fun", "age의 값은 ${age}이다.")
            Log.d("fun","weight의 값은 ${weight}이다.")
        }
        newFunction("Hello")
    }
}