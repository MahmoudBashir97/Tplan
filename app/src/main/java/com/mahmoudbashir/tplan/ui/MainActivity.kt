package com.mahmoudbashir.tplan.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.tplan.R
import dagger.hilt.android.AndroidEntryPoint


@RequiresApi(Build.VERSION_CODES.M)
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = resources.getColor(R.color.main_color,resources.newTheme())

    }
}