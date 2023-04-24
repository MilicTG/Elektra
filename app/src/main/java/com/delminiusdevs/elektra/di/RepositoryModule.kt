package com.delminiusdevs.elektra.di

import com.delminiusdevs.elektra.data.repository.BranchesRepositoryImpl
import com.delminiusdevs.elektra.data.repository.PowerOutagesRepositoryImpl
import com.delminiusdevs.elektra.domain.repository.BranchesRepository
import com.delminiusdevs.elektra.domain.repository.PowerOutagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindOutagesRepository(
        powerOutagesRepositoryImpl: PowerOutagesRepositoryImpl,
    ): PowerOutagesRepository

    @Binds
    @Singleton
    abstract fun bindBranchesRepository(
        branchesRepositoryImpl: BranchesRepositoryImpl,
    ): BranchesRepository
}