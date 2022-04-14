package com.coolme.me.twitterclientside.dataLayer.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.datetime.toInstant
import kotlinx.serialization.Serializable

@Serializable
class UserRealm : RealmObject
{
    var token: String = ""
    var _id : String = ""
    @PrimaryKey
    var username:String = ""
    var email: String = ""
    var idNumber: Int = 0
    var ip: String = ""
    var disabled: Boolean = false
    var isLogin: Boolean = false
    var lastTimeLoginUTC : String = ""
    var createdAt : String = ""
    var updatedAt: String = ""

    fun toUser() : User
    {
        return User(
            token= token,
            _id= _id,
            username= username,
            email=email,
            idNumber=idNumber,
            ip= ip,
            disabled= disabled,
            isLogin= isLogin,
            lastTimeLoginUTC= lastTimeLoginUTC.toInstant(),
            createdAt= createdAt.toInstant(),
            updatedAt= updatedAt.toInstant(),
                   )
    }
}