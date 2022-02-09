package com.example.pam_tp2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_tp2.R
import com.example.pam_tp2.adapter.JokeAdapter

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

        val rv = view?.findViewById<RecyclerView>(R.id.jokes_rv)
        rv?.layoutManager = LinearLayoutManager(context)
        val adapter = JokeAdapter(mutableListOf())
        rv?.adapter = adapter

        viewModel.liveData.observe(this) { list ->
            adapter.updateJokeList(list)
        }
        viewModel.getJokesFromRemote()

    }

}