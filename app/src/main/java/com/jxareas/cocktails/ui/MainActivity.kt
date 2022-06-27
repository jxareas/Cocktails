package com.jxareas.cocktails.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jxareas.cocktails.R
import com.jxareas.cocktails.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}
