package com.inheritanceandextension

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 부모 클래스 직접 호출하기


        testStringExtension()
    }

    // String 익스텐션 테스트 하기
    fun testStringExtension(){
        var original = "Hello"
        var added = " Guys~"
        // plus 메서드를 사용해서 문자열을 더할 수 있다.
        Log.d("Extension", "added를 더한 값은 ${original.plus(added)}")
    }

    // 상속 연습
    open class Parent {
        var  hello: String = "안녕하세요"
        fun sayHello() {
            Log.d("Extension", "${hello}")
        }
    }
    class Child: Parent(){
        fun myHello(){
            hello = "Hello"
            sayHello()
        }
    }
    // 메서드 오버라이드연습
    open class BaseClase {
        open fun opened(){

        }
        fun notOpend(){

        }
    }
    class ChildClass: BaseClase() {
        override fun opened() {
        }
        // 오버라이드 되지 않고 에러가 발생한다.
//        override fun notOpend(){
//
//        }
    }

    // 프로퍼티 오버라이드 연습
    open class BaseClass2 {
        open var opened: String = "I am"
    }
    class ChildClass2: BaseClass2() {
        override var opened: String = "You are"
    }

    fun String.plus(word: String): String {
        return this + word
    }
}