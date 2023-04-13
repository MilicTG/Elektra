package com.delminiusdevs.elektra.di

import com.delminiusdevs.elektra.domain.repository.PowerOutagesRepository
import com.delminiusdevs.elektra.domain.use_cases.outages_use_cases.GetAllPowerOutagesUseCase
import com.delminiusdevs.elektra.domain.use_cases.outages_use_cases.OutagesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OutagesModule {

    @Singleton
    @Provides
    fun provideOutagesUseCases(
        powerOutagesRepository: PowerOutagesRepository
    ) = OutagesUseCases(
        getAllPowerOutagesUseCase = GetAllPowerOutagesUseCase(powerOutagesRepository = powerOutagesRepository)
    )
}