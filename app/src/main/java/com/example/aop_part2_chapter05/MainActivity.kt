package com.example.aop_part2_chapter05

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val addPhotoBtn: Button by lazy {
        findViewById<Button>(R.id.addPhotoBtn)
    }

    private val startPhotoFrameModeBtn: Button by lazy {
        findViewById<Button>(R.id.startPhotoFromModeBtn)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}