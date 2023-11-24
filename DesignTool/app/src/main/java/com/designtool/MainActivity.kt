package com.designtool

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 접근 제한자 테스트
        var child = Child()
        child.callVariables()

        // 부노 클래스 직접 호출해보기
        var parent = Parent()
        Log.d("Visibility", "Parent: 기본 제한자 defaultVal의 값은 ${parent.defaultVal}")
        Log.d("Visibility", "Parent: internal의 값은 ${parent.internalVal}")
    }
}

// 추상 클래스 설계
abstract class Animal {
    fun walk(){
        fun walk(){
            Log.d("abstract", "걷는다.")
        }
        abstract fun move()
    }
}

// 구현
class Bird: Animal() {
    override fun move() {
        Log.d("abstract", "날아서 이동한다.")
    }
}

interface InterfaceKotlin {
    var variable: String
    fun get()
    fun set()
}

class KotlinImpl: InterfaceKotlin {
    override var variable: String = "init value"
    override fun get(){
        // 코드 구현
    }
    override  fun set(){
        // 코드 구현
    }
}

var kotlinImpl = object: InterfaceKotlin {
    override var variable: String = "init"
    override fun get(){
        // 코드
    }

    override fun set() {
        // 코드
    }
}

// 접근 제한자 테스트를 위한 부모 클래스
open class Parent {
    private val privateVal = 1
    protected open val protectedVal = 2
    internal val internalVal = 3
    val defaultVal = 4
}

// 자식 클래스
class Child: Parent(){
    fun callVariables() {
        // privateVal은 호출이 되지 않는다.
//        Log.d("Visibiltiy", "Child: privateVal의 값은 ${privateVal}")
        Log.d("Visibiltiy", "Child: protectedVal의 값은 ${protectedVal}")
        Log.d("Visibiltiy", "Child: internalVal의 값은 ${internalVal}")
        Log.d("Visibiltiy", "Child: defaultVal의 값은 ${defaultVal}")
    }
}