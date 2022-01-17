package com.example.pam_tp2.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pam_tp2.model.Joke
import com.example.pam_tp2.model.Jokes
import com.example.pam_tp2.service.CallService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class JokeListViewModel : ViewModel() {

    private val callApi = CallService()
    val liveData: MutableLiveData<Jokes> = MutableLiveData<Jokes>(Jokes(listOf()))

    fun getJokesFromRemote() = viewModelScope.launch {
        // val strings: List<String> = listOf("ok", "ok2")

        val jokes: Jokes = Jokes(listOf(Joke(45, "cat", "typ", "set", "deli")))

        Log.v("LAUNCH", "launch")

        liveData.value = jokes

        liveData.value = callApi.callJokeAPI()
    }
}