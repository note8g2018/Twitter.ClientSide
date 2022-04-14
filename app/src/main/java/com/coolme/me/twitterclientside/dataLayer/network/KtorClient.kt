package com.coolme.me.twitterclientside.dataLayer.network

import android.util.Log
import com.coolme.me.twitterclientside.baseURLSho
import com.coolme.me.twitterclientside.portSho
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class KtorClient
{
    val httpClient : HttpClient = HttpClient(Android) {
        this.followRedirects = true
        install(HttpRedirect) {
            checkHttpMethod = false
        }
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                encodeDefaults = true
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
        install(HttpTimeout) {
            this.socketTimeoutMillis = 15000L
            this.requestTimeoutMillis = 15000L
            this.connectTimeoutMillis = 15000L
        }
        install(Logging){
            this.logger = object : Logger
            {
                override fun log(message: String)
                {
                    Log.i("Network", message)
                }
            }
            this.level = LogLevel.ALL
        }
        defaultRequest {
            this.url {
                this.host = baseURLSho
                this.port = portSho
            }
            this.contentType(ContentType.Application.Json)
            this.accept(ContentType.Application.Json)
        }
    }
}