package com.delminiusdevs.elektra.di

import com.delminiusdevs.elektra.data.remote.ElectraApi
import com.delminiusdevs.elektra.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideElectraApi(retrofit: Retrofit): ElectraApi {
        return retrofit.create(ElectraApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun providePowerOutagesSource(
//        electraApi: ElectraApi,
//        branchesDatabase: BranchesDatabase
//    ): PowerOutagesRepository {
//        return PowerOutagesRepositoryImpl(
//            electraApi = electraApi,
//            branchesDatabase = branchesDatabase
//        )
//    }
}