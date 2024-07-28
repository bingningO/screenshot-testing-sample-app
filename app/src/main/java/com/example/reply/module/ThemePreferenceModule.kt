package com.example.reply.module

import android.content.Context
import com.example.reply.data.ThemePreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ThemePreferenceModule {
    @Provides
    @Singleton
    fun provideThemePreference(
        @ApplicationContext context: Context
    ): ThemePreference {
        return ThemePreference(context)
    }
}
