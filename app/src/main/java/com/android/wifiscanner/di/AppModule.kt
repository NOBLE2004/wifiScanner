package com.android.wifiscanner.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.android.wifiscanner.model.database.WifiDatabase

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideRoom(application: Application): WifiDatabase {
        return Room.databaseBuilder(
            application,
            WifiDatabase::class.java, "wif_database"
        ).build()
    }

}