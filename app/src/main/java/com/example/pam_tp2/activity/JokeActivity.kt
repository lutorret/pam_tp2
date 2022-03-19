package com.example.pam_tp2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.pam_tp2.R

/**
 * Représente l'écran affichant la blague dans son ensemble.
 */
class JokeActivity : AppCompatActivity() {

    val iconMap = mapOf<String, Int>(
        "Programming" to R.drawable.ic_baseline_computer_24,
        "Misc" to R.drawable.ic_baseline_miscellaneous_services_24,
        "Dark" to R.drawable.ic_baseline_dark_mode_24,
        "Pun" to R.drawable.ic_baseline_live_help_24,
        "Spooky" to R.drawable.ic_baseline_outlet_24,
        "Christmas" to R.drawable.ic_baseline_card_giftcard_24
    )

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

        if (intent.extras?.get("joke") != null) {
            setup.visibility = View.INVISIBLE
            delivery.visibility = View.INVISIBLE
            titleSetup.visibility = View.INVISIBLE
            titleDelivery.visibility = View.INVISIBLE
        }
        else {
            joke.visibility = View.INVISIBLE
            titleJoke.visibility = View.INVISIBLE
        }
    }

}