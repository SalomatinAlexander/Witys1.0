package com.example.Witys.presentation.start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.Witys.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceMyFragment(RegistFragment())


    }
    fun replaceMyFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().add(
            R.id.container_layout,
            fragment, "regist").commit()

    }
}