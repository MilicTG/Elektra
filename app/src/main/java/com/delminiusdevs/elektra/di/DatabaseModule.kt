package com.delminiusdevs.elektra.di

import android.app.Application
import androidx.room.Room
import com.delminiusdevs.elektra.data.local.ElectraDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideElectraDatabase(app: Application): ElectraDatabase {
        return Room.databaseBuilder(
            app,
            ElectraDatabase::class.java,
            "electra.db"
        ).build()
    }
}