package com.collection

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 값으로 컬렉션 생성하기
        var mutableList = mutableListOf("MON", "TUE", "WED")
        // 값을 추가
        mutableList.add("THU")
        // 값을 꺼낸다
        Log.d("Collection", "mutableList의 첫 번째 값은 ${mutableList.get(0)}이다.")
        // 값을 수정
        mutableList.set(1,"수정")
        // 값 제거
        mutableList.removeAt(0)
        Log.d("Collection", "${mutableList}")

        // 생성
        var stringList = mutableListOf<String>()    // 문자열로 된 빈 컬렉션을 생성
        // 입력
        stringList.add("월")
        stringList.add("화")
        // 사용
        Log.d("Collection", "stringList에 입력된 두번 쨰 값은 ${stringList.get(1)}")
        // 수정
        stringList.set(1, "수정된 값")
        // 삭제
        stringList.removeAt(1)  // 두번째 값이 삭제
        // 개수를 출력
        Log.d("Collection", "stringList에는 ${stringList.size}개의 값이 있다.")
    }
}