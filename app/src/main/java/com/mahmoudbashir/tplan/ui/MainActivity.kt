package com.mahmoudbashir.tplan.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.tplan.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val mainVM:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = Color.WHITE

//        lifecycleScope.launchWhenCreated {
//            mainVM.proList.observe(this@MainActivity){
//                if (!it.isNullOrEmpty()){
//                    Toast.makeText(this@MainActivity,"size : ${it.size}",Toast.LENGTH_LONG).show()
//                }
//            }
//        }
    }
}