package com.example.pam_tp2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.pam_tp2.R

class JokeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        // Titles
        val titleSetup: TextView = findViewById(R.id.titleSetup)
        val titleDelivery: TextView = findViewById(R.id.titleDelivery)
        val titleJoke: TextView = findViewById(R.id.titleJoke)

        // Values
        val category: TextView = findViewById(R.id.category)
        val type: TextView = findViewById(R.id.type)
        val setup: TextView = findViewById(R.id.setup)
        val delivery: TextView = findViewById(R.id.delivery)
        val joke: TextView = findViewById(R.id.joke)


        category.text = intent.extras?.get("category").toString()
        type.text = intent.extras?.get("type").toString()
        setup.text = intent.extras?.get("setup").toString()
        delivery.text = intent.extras?.get("delivery").toString()
        joke.text = intent.extras?.get("joke").toString()

        if (intent.extras?.get("setup") == null) {
            setup.visibility = View.INVISIBLE
            delivery.visibility = View.INVISIBLE
        }
        else
            joke.visibility = View.INVISIBLE
    }

}