package com.example.pam_tp2.service

import com.example.pam_tp2.model.Jokes
import com.google.gson.Gson

class ParseService {

    fun parseJson(json: String) : Jokes {
        return Gson().fromJson(json, Jokes::class.java)
    }

}