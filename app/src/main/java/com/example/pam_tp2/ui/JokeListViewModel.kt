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

/*
Passer des données d'un fragment à l'autre :
Soluce 1 : use Bundle (sérialisation), recoit l'objet en paramètre du fragment dans la value de la clé "data" de la map
Soluce 2 : use Bundle (singleton), passe juste l'id
Soluce 3 : passe l'id, le 2e fragment refait un appel api avec l'id
Soluce 4 : bdd
 */