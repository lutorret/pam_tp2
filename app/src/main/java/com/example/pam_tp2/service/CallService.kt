package com.example.pam_tp2.service

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*


class CallService {

    suspend fun callJokeAPI(): ByteArray {

        val url = "https://v2.jokeapi.dev/joke/Any?amount=12"

        val client: HttpClient = HttpClient()
        val resp: HttpResponse = client.get(url)
        val array: ByteArray = resp.receive()

        return array
    }

}