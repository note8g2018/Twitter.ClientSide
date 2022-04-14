package com.coolme.me.twitterclientside.dataLayer.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseSho<out T>(
    val error : Boolean,
    val statusCode : Int,
    val errorMessage: String? = null,
    val token : String? = null,
    val data : T? = null,
    val result: String? = null,
                             )
