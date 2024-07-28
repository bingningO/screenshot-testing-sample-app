package com.example.reply.module

import com.example.reply.data.LocalEmailsDataProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalEmailsDataModule {

    @Singleton
    @Provides
    fun provideLocalEmailsDataProvider(): LocalEmailsDataProvider {
        return LocalEmailsDataProvider()
    }
}
