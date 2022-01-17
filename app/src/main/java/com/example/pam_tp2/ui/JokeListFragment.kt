package com.example.pam_tp2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.pam_tp2.R

class JokeListFragment : Fragment() {

    val viewModel: JokeListViewModel by viewModels()

    companion object {
        fun newInstance() = JokeListFragment()
    }

    // private lateinit var viewModel: JokeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.joke_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // viewModel = ViewModelProvider(this).get(JokeListViewModel::class.java)
        // TODO: Use the ViewModel

        val textView = view?.findViewById(R.id.textView) as TextView

        viewModel.liveData.observe(this) { list ->
            if (list.jokes.isNotEmpty())
                textView.text = list.jokes.joinToString("\n")
            else
                textView.text = "Liste vide"

        }
        viewModel.getJokesFromRemote()
    }

}