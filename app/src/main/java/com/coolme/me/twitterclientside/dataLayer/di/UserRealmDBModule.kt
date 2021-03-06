package com.coolme.me.twitterclientside.dataLayer.di

import com.coolme.me.twitterclientside.dataLayer.model.UserRealm
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserRealmDBModule
{
    @UserRealmDB
    @Singleton
    @Provides
    fun provideUserRealmDB() : Realm
    {
        val config = RealmConfiguration
                .Builder(schema = setOf(UserRealm::class))
                .name("userRealmDB")
                .compactOnLaunch()
                .build()
        //val userRealmDB = Realm.open(config)
        return Realm.open(config)
        //return userRealmDB
    }
}