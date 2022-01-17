package com.example.pam_tp2.model

import com.google.gson.annotations.SerializedName

data class Jokes (
    @SerializedName("jokes")
    val jokes: List<Joke>
)
