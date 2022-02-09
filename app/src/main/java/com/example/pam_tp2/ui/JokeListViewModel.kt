package com.example.pam_tp2.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pam_tp2.model.Joke
import com.example.pam_tp2.model.Jokes
import com.example.pam_tp2.service.CallService
import kotlinx.coroutines.launch

class JokeListViewModel : ViewModel() {

    private val callApi = CallService()
    val liveData: MutableLiveData<List<Joke>> = MutableLiveData<List<Joke>>(listOf())

    fun getJokesFromRemote() = viewModelScope.launch {
        liveData.value = callApi.callJokeAPI().jokes
    }
}
