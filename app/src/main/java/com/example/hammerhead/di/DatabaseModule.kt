package com.example.hammerhead.di

import android.content.Context
import androidx.room.Room
import com.example.hammerhead.room.AppDatabase
import com.example.hammerhead.room.FoodDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun provideLogDao(database: AppDatabase): FoodDao {
        return database.foodDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "food.db"
        ).build()
    }
}