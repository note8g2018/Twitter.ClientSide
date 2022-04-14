package com.coolme.me.twitterclientside.dataLayer.model

import javax.inject.Inject
import kotlinx.serialization.Serializable

@Serializable
data class ErrorSho @Inject constructor(
    val error : Boolean,
    val statusCode : Int,
    val message : String,
    val title : String? = null,
    val type: String?,
                                  )
  //  : Exception()
