package com.coolme.me.twitterclientside.dataLayer.userInterface

import com.coolme.me.twitterclientside.dataLayer.model.User
import com.coolme.me.twitterclientside.dataLayer.model.UserRealm

interface UserLDB
{
    fun saveOrUpdateUser(user: User)

    fun saveOrUpdateUser(userPhone: UserRealm)

    fun getUserRealm(username: String): UserRealm?

    fun getUserRealm(): UserRealm?

    fun getUser(): User?

    fun deleteUser(user: User)
}