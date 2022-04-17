package com.coolme.me.twitterclientside.dataLayer.di

import com.coolme.me.twitterclientside.dataLayer.localDatabase.ArticleLDBImpl
import com.coolme.me.twitterclientside.dataLayer.localDatabase.UserLDBImpl
import com.coolme.me.twitterclientside.dataLayer.network.ArticleNetworkImpl
import com.coolme.me.twitterclientside.dataLayer.network.LoginNetworkImpl
import com.coolme.me.twitterclientside.dataLayer.network.RegistrationNetworkImpl
import com.coolme.me.twitterclientside.dataLayer.repository.ArticleRepositoryImpl
import com.coolme.me.twitterclientside.dataLayer.repository.LoginRepositoryImpl
import com.coolme.me.twitterclientside.dataLayer.repository.RegistrationRepositoryImpl
import com.coolme.me.twitterclientside.dataLayer.userInterface.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MyApplicationModule
{
    // Registration ************************************************

    @Binds
    abstract fun bindRegistrationRepository(
        registrationRepositoryImpl: RegistrationRepositoryImpl
                                           ): RegistrationRepository

    @Binds
    abstract fun bindRegistrationNetwork(
        registrationNetworkImpl: RegistrationNetworkImpl
                                        ): RegistrationNetwork

    @Binds
    abstract fun bindUserLDB(
        userLDBImpl: UserLDBImpl
                            ): UserLDB

    // Login ************************************************************

    @Binds
    abstract fun bindLoginRepository(
        loginRepositoryImpl: LoginRepositoryImpl
                                    ): LoginRepository

    @Binds
    abstract fun bindLoginNetwork(
        loginNetworkImpl: LoginNetworkImpl
                                        ): LoginNetwork

    // Article ************************************************************

    @Binds
    abstract fun bindArticleRepository(
        articleRepositoryImpl: ArticleRepositoryImpl
                                           ): ArticleRepository

    @Binds
    abstract fun bindArticleNetwork(
        articleNetworkImpl: ArticleNetworkImpl
                                        ): ArticleNetwork

    @Binds
    abstract fun bindArticleLDB(
        articleLDBImpl: ArticleLDBImpl
                            ): ArticleLDB

}