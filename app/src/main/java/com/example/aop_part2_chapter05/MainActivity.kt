package com.example.aop_part2_chapter05

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val addPhotoBtn: Button by lazy {
        findViewById<Button>(R.id.addPhotoBtn)
    }

    private val startPhotoFrameModeBtn: Button by lazy {
        findViewById<Button>(R.id.startPhotoFromModeBtn)
    }

    private val imageViewList: List<ImageView> by lazy {
        mutableListOf<ImageView>().apply {
            add(findViewById(R.id.imageView1))
            add(findViewById(R.id.imageView2))
            add(findViewById(R.id.imageView3))
            add(findViewById(R.id.imageView4))
            add(findViewById(R.id.imageView5))
            add(findViewById(R.id.imageView6))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAddPhotoBtn()
        initStartPhotoFrameModeBtn()
    }

    private fun initAddPhotoBtn() {

        addPhotoBtn.setOnClickListener {
            when {
                ContextCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {
//                    TODO 권한이 잘 부여되었을 때 갤러리에서 사진을 선택하는 기능
                }
                shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE) -> {
//                    todo 교육용 팝업 확인 후 권한 팝업을 띄우는 기능

                    showPermissionContextPopup()
                }
                else -> {
                    requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
                }
            }
        }
    }

    private fun showPermissionContextPopup() {
        AlertDialog.Builder(this)
                .setTitle("권한이 필요합니다.")
                .setMessage("전자 액자에 앱에서 사진을 불러오기 위해 권한이 필요합니다.")
                .setPositiveButton("동의하기") { _, _ ->
                    requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
                }
                .setNegativeButton("취소하기") { _, _ -> }
                .create()
                .show()
    }

    private fun initStartPhotoFrameModeBtn() {

    }
}