package com.example.pam_tp2.model

import com.google.gson.annotations.SerializedName


/**
 * Classe du modèle sérialisée en JSON possédant un attribut jokes : liste de Joke
 */
data class Jokes (
    @SerializedName("jokes")
    val jokes: List<Joke>
)
