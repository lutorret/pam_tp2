package com.example.pam_tp2.model

import com.google.gson.annotations.SerializedName

/**
 * Classe du modèle sérialisée en JSON représentant une Joke de l'API appelée
 */
data class Joke (
    @SerializedName("id")
    val id: Int,
    @SerializedName("category")
    val category: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("joke")
    val joke: String,
    @SerializedName("setup")
    val setup: String,
    @SerializedName("delivery")
    val delivery: String

)
{
    override fun toString(): String {
        return "Joke (id=$id, category='$category', type='$type', joke='$joke', setup='$setup', delivery='$delivery')"
    }
}