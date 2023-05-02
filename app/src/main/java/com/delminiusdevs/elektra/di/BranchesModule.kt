package com.delminiusdevs.elektra.di

import com.delminiusdevs.elektra.domain.repository.BranchesRepository
import com.delminiusdevs.elektra.domain.use_cases.branches_use_cases.BranchesUseCases
import com.delminiusdevs.elektra.domain.use_cases.branches_use_cases.GetAllBranchOfficesUseCase
import com.delminiusdevs.elektra.domain.use_cases.branches_use_cases.GetAllSubscribedBranchesUseCase
import com.delminiusdevs.elektra.domain.use_cases.branches_use_cases.SubscribeToBranchOfficeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BranchesModule {

    @Singleton
    @Provides
    fun provideBranchesUseCases(
        branchesRepository: BranchesRepository,
    ) = BranchesUseCases(
        getAllBranchOfficesUseCase = GetAllBranchOfficesUseCase(branchesRepository = branchesRepository),
        subscribeToBranchOfficeUseCase = SubscribeToBranchOfficeUseCase(branchesRepository = branchesRepository),
        getAllSubscribedBranchesUseCase = GetAllSubscribedBranchesUseCase(branchesRepository = branchesRepository)
    )
}