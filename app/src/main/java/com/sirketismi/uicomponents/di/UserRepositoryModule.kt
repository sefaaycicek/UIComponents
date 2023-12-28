package com.sirketismi.uicomponents.di

import com.sirketismi.uicomponents.repository.ProductRepository
import com.sirketismi.uicomponents.repository.ProductRepositoryInterface
import com.sirketismi.uicomponents.repository.UserRepoInterface
import com.sirketismi.uicomponents.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryModule {
    @Binds
    abstract fun bindRepository(prm : UserRepository) : UserRepoInterface

    @Binds
    abstract fun bindProductRepository(prm : ProductRepository) : ProductRepositoryInterface
}