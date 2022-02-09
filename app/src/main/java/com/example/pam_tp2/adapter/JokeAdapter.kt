package com.example.pam_tp2.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_tp2.R
import com.example.pam_tp2.activity.JokeActivity
import com.example.pam_tp2.model.Joke

class JokeAdapter(private var dataset: MutableList<Joke>) : RecyclerView.Adapter<JokeAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val category: TextView
        val type: TextView

        init {
            // Define click listener for the ViewHolder's View.
            category = view.findViewById(R.id.category)
            type = view.findViewById(R.id.type)

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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (!dataset.isEmpty()) {
            holder.category.text = dataset[position].category
            holder.type.text = dataset[position].type
            if (dataset[position].type == "twopart") {
                /*
                holder.setup.text = dataset[position].setup
                holder.delivery.text = dataset[position].delivery
                holder.joke.visibility = View.INVISIBLE*/
            }
            else {/*
                holder.joke.text = dataset[position].joke
                holder.setup.visibility = View.INVISIBLE
                holder.delivery.visibility = View.INVISIBLE
            */}
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun updateJokeList(jokes: List<Joke>) {
        dataset.addAll(jokes)
        notifyDataSetChanged()
    }

}