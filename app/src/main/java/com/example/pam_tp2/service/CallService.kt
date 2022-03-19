package com.example.pam_tp2.service

import com.example.pam_tp2.model.Jokes
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.request.*
import io.ktor.client.statement.*



class CallService {

    /**
     * Fonction appelant l'API v2.jokeapi.dev
     * Retourne un objet Jokes (liste de Joke)
     */
    suspend fun callJokeAPI(): Jokes {
        val client = HttpClient(Android)
        val parse = ParseService()

        val url = "https://v2.jokeapi.dev/joke/Any?amount=10"

        val resp: HttpResponse = client.get(url)
        val json: String = resp.receive()

        client.close()

        return parse.parseJson(json)
    }

}