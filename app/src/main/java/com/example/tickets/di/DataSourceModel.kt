package com.example.tickets.di

import com.example.tickets.repository.FakeDataSource
import com.example.tickets.repository.FakeDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModel {
    @Binds
    abstract fun provideFakeDataSource(fakeDataSource: FakeDataSourceImpl): FakeDataSource
}
