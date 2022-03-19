package com.example.pam_tp2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.pam_tp2.R

/**
 * Représente l'écran affichant la blague dans son ensemble.
 */
class JokeActivity : AppCompatActivity() {

    val categoryIconMap = mapOf<String, Int>(
        "Programming" to R.drawable.ic_baseline_computer_40,
        "Misc" to R.drawable.ic_baseline_miscellaneous_services_40,
        "Dark" to R.drawable.ic_baseline_dark_mode_40,
        "Pun" to R.drawable.ic_baseline_live_help_40,
        "Spooky" to R.drawable.ic_baseline_outlet_40,
        "Christmas" to R.drawable.ic_baseline_card_giftcard_40
    )

    val typeIconMap = mapOf<String, Int>(
        "twopart" to R.drawable.ic_baseline_question_answer_40,
        "single" to R.drawable.ic_baseline_speaker_notes_40
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

        // Images
        val typeIcon: ImageView = findViewById(R.id.typeIcon)
        val categoryIcon: ImageView = findViewById(R.id.categoryIcon)


        category.text = intent.extras?.get("category").toString()
        type.text = intent.extras?.get("type").toString()
        setup.text = intent.extras?.get("setup").toString()
        delivery.text = intent.extras?.get("delivery").toString()
        joke.text = intent.extras?.get("joke").toString()

        typeIcon.setImageResource(typeIconMap.getOrDefault(type.text, 0))
        categoryIcon.setImageResource(categoryIconMap.getOrDefault(category.text, 0))

        if (intent.extras?.get("joke") != null) {
            setup.visibility = View.GONE
            delivery.visibility = View.GONE
            titleSetup.visibility = View.GONE
            titleDelivery.visibility = View.GONE
        }
        else {
            joke.visibility = View.GONE
            titleJoke.visibility = View.GONE
        }
    }

}