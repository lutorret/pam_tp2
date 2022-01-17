package com.example.pam_tp2.model

import com.google.gson.annotations.SerializedName

data class Joke (
    @SerializedName("id")
    val id: Int,
    @SerializedName("category")
    val category: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("setup")
    val setup: String,
    @SerializedName("delivery")
    val delivery: String

)
{
    override fun toString(): String {
        return "Joke(id=$id, category='$category', type='$type', setup='$setup', delivery='$delivery')"
    }
}