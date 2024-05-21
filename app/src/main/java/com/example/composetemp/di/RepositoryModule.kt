package com.example.composetemp.di

import com.example.composetemp.data.local.repository.RepositoryImpl
import com.example.composetemp.domain.repository.Repository
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
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl):Repository
    }