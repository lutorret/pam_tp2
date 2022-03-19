package com.example.pam_tp2.service

import com.example.pam_tp2.model.Jokes
import com.google.gson.Gson

class ParseService {

    /**
     * Fonction parsant une chaine de caractère en l'objet Jokes
     * Retourne un objet Jokes (contient une liste de Joke)
     */
    fun parseJson(json: String) : Jokes {
        return Gson().fromJson(json, Jokes::class.java)
    }

}