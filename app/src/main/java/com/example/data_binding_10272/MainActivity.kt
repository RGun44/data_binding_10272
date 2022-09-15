package com.example.data_binding_10272

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        DataBindingUtil.setContentView<com.example.data_binding_10272.databinding.ActivityMainBinding>(
            this,R.layout.activity_main
        ).apply {
            this.lifecycleOwner = this@MainActivity
            this.viewmodel = mainViewModel
        }

        mainViewModel.editTextContent.observe(this){
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        }
    }
}