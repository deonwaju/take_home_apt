package com.example.take_home_apt.di

import com.example.take_home_apt.data.repo.IShipmentRepo
import com.example.take_home_apt.data.repo.ShipmentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideIShipmentRepository(
        ioDispatcher: CoroutineDispatcher,
    ): IShipmentRepo = ShipmentRepositoryImpl()
}