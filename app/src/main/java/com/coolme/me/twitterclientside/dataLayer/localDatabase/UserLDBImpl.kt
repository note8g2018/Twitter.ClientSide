package com.coolme.me.twitterclientside.dataLayer.localDatabase

import com.coolme.me.twitterclientside.dataLayer.di.UserRealmDB
import com.coolme.me.twitterclientside.dataLayer.model.User
import com.coolme.me.twitterclientside.dataLayer.model.UserRealm
import com.coolme.me.twitterclientside.dataLayer.userInterface.UserLDB
import io.realm.Realm
import io.realm.query
import javax.inject.Inject

class UserLDBImpl @Inject constructor(
    @UserRealmDB private val userRealmDB: Realm,
                                     ) : UserLDB
{
    override fun saveOrUpdateUser(user: User)
    {
        println(userRealmDB.configuration.path)
        userRealmDB.writeBlocking  {
            val userRealm: UserRealm? = this
                    .query<UserRealm>("username == $0", user.username)
                    .first().find()
            if(userRealm != null)
            {
                userRealm.token = user.token!!
                userRealm._id = user._id
                //userRealm.username = user.username
                userRealm.email = user.email
                userRealm.idNumber = user.idNumber
                userRealm.ip = user.ip
                userRealm.disabled = user.disabled!!
                userRealm.isLogin = user.isLogin
                userRealm.lastTimeLoginUTC = user.lastTimeLoginUTC.toString()
                userRealm.createdAt = user.createdAt.toString()
                userRealm.updatedAt = user.updatedAt.toString()
            }
            else
            {
                this.copyToRealm(user.toUserRealm())
            }
        }
    }

    override fun saveOrUpdateUser(userPhone: UserRealm)
    {
        println(userRealmDB.configuration.path)
        userRealmDB.writeBlocking  {
            val userRealm: UserRealm? = this
                .query<UserRealm>("username == $0", userPhone.username)
                .first().find()
            if(userRealm != null)
            {
                userRealm.token = userPhone.token!!
                userRealm._id = userPhone._id
                //userRealm.username = user.username
                userRealm.email = userPhone.email
                userRealm.idNumber = userPhone.idNumber
                userRealm.ip = userPhone.ip
                userRealm.disabled = userPhone.disabled!!
                userRealm.isLogin = userPhone.isLogin
                userRealm.lastTimeLoginUTC = userPhone.lastTimeLoginUTC.toString()
                userRealm.createdAt = userPhone.createdAt.toString()
                userRealm.updatedAt = userPhone.updatedAt.toString()
            }
            else
            {
                this.copyToRealm(userPhone)
            }
        }
    }

    override fun getUserRealm(username: String): UserRealm?
    {
        return userRealmDB
                .query<UserRealm>("username == $0", username)
                .first().find()
    }

    override fun getUserRealm(): UserRealm?
    {
        return userRealmDB
                .query<UserRealm>()
                .first().find()
    }

    override fun getUser(): User?
    {
        return userRealmDB
                .query<UserRealm>()
                .first().find()?.toUser()
    }

    override fun deleteUser(user: User)
    {
        userRealmDB.writeBlocking {
            // fetch the frog by primary key value, passed in as argument number 0
            val userRealm: UserRealm? =
                this.query<UserRealm>("username == $0", user.username).first().find()
            // call delete on the results of a query to delete the object permanently
            //userRealm?.also { delete(it) }
            delete(userRealm!!)
        }
    }
}