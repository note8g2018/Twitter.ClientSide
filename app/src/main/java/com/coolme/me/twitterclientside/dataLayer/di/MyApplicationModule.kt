package com.coolme.me.twitterclientside.dataLayer.di

import com.coolme.me.twitterclientside.dataLayer.localDatabase.LocalDatabaseImpl
import com.coolme.me.twitterclientside.dataLayer.network.LoginNetworkImpl
import com.coolme.me.twitterclientside.dataLayer.network.RegistrationNetworkImpl
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
    @Binds
    abstract fun bindLocalDatabase(
        localDatabaseImpl: LocalDatabaseImpl
                                           ): LocalDatabase

    @Binds
    abstract fun bindRegistrationRepository(
        registrationRepositoryImpl: RegistrationRepositoryImpl
                                           ): RegistrationRepository

    @Binds
    abstract fun bindRegistrationNetwork(
        registrationNetworkImpl: RegistrationNetworkImpl
                                           ): RegistrationNetwork

    @Binds
    abstract fun bindLoginRepository(
        loginRepositoryImpl: LoginRepositoryImpl
                                           ): LoginRepository

    @Binds
    abstract fun bindLoginNetwork(
        loginNetworkImpl: LoginNetworkImpl
                                        ): LoginNetwork

}