package com.example.aop_part2_chapter05

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlin.concurrent.timer

class PhotoFrameActivity : AppCompatActivity() {

    private val photoList = mutableListOf<Uri>()

    private val backgroundPhotoImageView: ImageView by lazy {
        findViewById<ImageView>(R.id.backgroundPhotoImageView)
    }

    private val photoImageView: ImageView by lazy {
        findViewById<ImageView>(R.id.photoImageView)
    }

    private var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_frame)

        getPhotoUriPromIntent()

    }


    private fun getPhotoUriPromIntent() {
        val size = intent.getIntExtra("photoListSize", 0)
        for (i in 0..size) {
            intent.getStringExtra("photo$i")?.let {
                photoList.add(Uri.parse(it))
            }
        }
    }
}