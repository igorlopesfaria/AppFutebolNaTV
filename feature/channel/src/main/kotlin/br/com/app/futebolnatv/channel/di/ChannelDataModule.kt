package br.com.app.futebolnatv.channel.di

import br.com.app.futebolnatv.channel.data.ChannelRepositoryImpl
import br.com.app.futebolnatv.channel.data.mapper.ChannelMapper
import br.com.app.futebolnatv.channel.data.mapper.ChannelMapperImpl
import br.com.app.futebolnatv.channel.domain.repository.ChannelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ChannelDataModule {

    @Provides
    fun provideChannelRepository(repository: ChannelRepositoryImpl): ChannelRepository = repository

    @Provides
    fun provideChannelMapper(mapper: ChannelMapperImpl): ChannelMapper = mapper
}