package com.coolme.me.twitterclientside.dataLayer.model

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class User(
    var token: String = "",
    var _id : String = "",
    var username:String = "",
    var nickname:String = "",
    var email: String = "",
    var idNumber: Int = 0,
    var ip: String = "",
    var disabled: Boolean = false,
    var isLogin: Boolean = false,
    var lastTimeLoginUTC : Instant = Instant.DISTANT_FUTURE,
    var createdAt : Instant = Instant.DISTANT_FUTURE,
    var updatedAt: Instant = Instant.DISTANT_FUTURE,
               )
{
    fun toUserRealm(): UserRealm
    {
        val temp = UserRealm()
        temp.token = token
        temp._id = _id
        temp.username = username
        temp.nickname = nickname
        temp.email = email
        temp.idNumber = idNumber
        temp.ip = ip
        temp.disabled = disabled
        temp.isLogin = isLogin
        temp.lastTimeLoginUTC = lastTimeLoginUTC.toString()
        temp.createdAt = createdAt.toString()
        temp.updatedAt = updatedAt.toString()
        return temp
    }
}
