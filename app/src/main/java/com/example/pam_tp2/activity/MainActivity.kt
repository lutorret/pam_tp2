package com.example.pam_tp2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pam_tp2.R
import com.example.pam_tp2.service.CallService
import com.example.pam_tp2.ui.JokeListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment = JokeListFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment)
            .commitAllowingStateLoss()

    }
}