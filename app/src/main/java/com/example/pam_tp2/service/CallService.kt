package com.example.pam_tp2.service

import android.util.Log
import com.example.pam_tp2.model.Jokes
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*


class CallService {

    private val client: HttpClient = HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }
    private val parse = ParseService()

    suspend fun callJokeAPI(): Jokes {

        val url = "https://v2.jokeapi.dev/joke/Any?amount=12"

        val resp: HttpResponse = client.get(url)
        val json: String = resp.receive()

        client.close()

        Log.v("JSON", json)

        return parse.parseJson(json)
    }



}