package com.coolme.me.twitterclientside.dataLayer.di

import com.coolme.me.twitterclientside.dataLayer.model.ArticleRealm
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArticleRealmDBModule
{
    @ArticleRealmDB
    @Singleton
    @Provides
    fun provideArticleRealmDB() : Realm
    {
        val config = RealmConfiguration
            .Builder(schema = setOf(ArticleRealm::class))
            .name("articleRealmDB")
            .compactOnLaunch()
            .build()
        //val articleRealmDB = Realm.open(config)
        return Realm.open(config)
        //return articleRealmDB
    }
}