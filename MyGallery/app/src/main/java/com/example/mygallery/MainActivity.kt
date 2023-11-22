package com.example.mygallery

import android.Manifest
import android.app.AlertDialog
import android.content.ContentUris
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.mygallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
            if (isGranted) {
                // 권한 허용됨
                getAllPhotos()
            } else {
                // 권한 거부
                Toast.makeText(this, "권한 거부 됨", Toast.LENGTH_SHORT).show()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 권한이 부여되었는지 확인
        if (
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // 이전 권한이 허용되지 않음
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        ) {
            // 이전에 이미 권한이 거부되었을 때 설명
            AlertDialog.Builder(this).apply {
                setTitle("권한이 필요한 이유")
                setMessage("사진 정보를 얻으려면 외부 저장소 권한이 필요합니다.")
                setPositiveButton("권한 요청") {_, _ ->
                    // 권한 요청
                    requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                }
                setNegativeButton("거부", null)
            }.show()
        } else {
            // 권한 요청
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        return
        }
        // 권한이 이미 허용됨
        getAllPhotos()
    }

    private fun getAllPhotos(){
        val uris = mutableListOf<Uri>()

        // 모든 사진 정보 가져오기
        contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null,
            null,
            null,
            "${MediaStore.Images.ImageColumns.DATE_TAKEN} DESC" // 찍은 날짜 내림차순
        )?.use { cursor ->
            while (cursor.moveToNext()) {
                // 사진 정보 id
                val id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID))
                // Uri 얻기
                val contentUri = ContentUris.withAppendedId(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    id
                )
                // 사진의 Uri들 리스트에 담기
                uris.add(contentUri)
            }
        }
        Log.d("MainActivity", "getAllPhotos: $uris")

        // ViewPager2 어댑터 연결
        val adapter = MyPagerAdapter(supportFragmentManager, lifecycle)
        adapter.uris = uris

        binding.viewPager.adapter = adapter
    }
}