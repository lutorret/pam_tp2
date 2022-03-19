package com.example.pam_tp2.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_tp2.R
import com.example.pam_tp2.activity.JokeActivity
import com.example.pam_tp2.model.Joke

class JokeAdapter(private var dataset: MutableList<Joke>) : RecyclerView.Adapter<JokeAdapter.ViewHolder>() {

    val typeIconMap = mapOf<String, Int>(
        "twopart" to R.drawable.ic_baseline_question_answer_40,
        "single" to R.drawable.ic_baseline_speaker_notes_40
    )

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val category: TextView
        val type: TextView
        val icon: ImageView

        init {
            category = view.findViewById(R.id.category)
            type = view.findViewById(R.id.type)
            icon = view.findViewById(R.id.typeIcon)

            // définit le changement d'écran lors d'un clique sur une blague de la liste
            view.setOnClickListener {
                val i = this.adapterPosition
                val context = category.context

                val intent = Intent(context, JokeActivity::class.java).apply {
                    putExtra("category", dataset[i].category)
                    putExtra("type", dataset[i].type)
                    putExtra("setup", dataset[i].setup)
                    putExtra("delivery", dataset[i].delivery)
                    putExtra("joke", dataset[i].joke)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_card, parent, false)

        return ViewHolder(view)
    }

    /**
     * Lie les données du dataset au viewHolder
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (!dataset.isEmpty()) {
            holder.category.text = dataset[position].category
            holder.type.text = dataset[position].type
            holder.icon.setImageResource(typeIconMap.getOrDefault(holder.type.text, 0))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    /**
     * Met à jour la liste de joke affichée et notifie les changements
     */
    fun updateJokeList(jokes: List<Joke>) {
        dataset.addAll(jokes)
        notifyDataSetChanged()
    }

}