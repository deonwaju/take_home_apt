package com.example.take_home_apt.di

import com.example.take_home_apt.data.repo.ISearchRepository
import com.example.take_home_apt.data.repo.IShipmentRepository
import com.example.take_home_apt.data.repo.SearchRepositoryImpl
import com.example.take_home_apt.data.repo.ShipmentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideIShipmentRepository(): IShipmentRepository = ShipmentRepositoryImpl()

    @Provides
    @Singleton
    fun provideISearchRepository(): ISearchRepository = SearchRepositoryImpl()
}