package com.coolme.me.twitterclientside.dataLayer.model

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class User(
    var token: String? = null,
    var _id : String,
    var username:String,
    var email: String,
    var idNumber: Int,
    var ip: String,
    var disabled: Boolean? = false,
    var isLogin: Boolean,
    var lastTimeLoginUTC : Instant,
    var createdAt : Instant,
    var updatedAt: Instant,
               )
{
    fun toUserRealm(): UserRealm
    {
        val temp = UserRealm()
        temp.token = token!!
        temp._id = _id
        temp.username = username
        temp.email = email
        temp.idNumber = idNumber
        temp.ip = ip
        temp.disabled = disabled!!
        temp.isLogin = isLogin
        temp.lastTimeLoginUTC = lastTimeLoginUTC.toString()
        temp.createdAt = createdAt.toString()
        temp.updatedAt = updatedAt.toString()
        return temp
    }
}
