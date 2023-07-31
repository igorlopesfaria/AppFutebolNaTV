package br.com.app.futebolnatv.match.di

import br.com.app.futebolnatv.match.data.MatchRepositoryImpl
import br.com.app.futebolnatv.match.data.mapper.ChampionshipMapper
import br.com.app.futebolnatv.match.data.mapper.ChampionshipMapperImpl
import br.com.app.futebolnatv.match.data.mapper.MatchMapper
import br.com.app.futebolnatv.match.data.mapper.MatchMapperImpl
import br.com.app.futebolnatv.match.domain.repository.MatchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class MatchDataModule {

    @Provides
    fun provideMatchRepository(repository: MatchRepositoryImpl): MatchRepository = repository

    @Provides
    fun provideMatchMapper(mapper: MatchMapperImpl): MatchMapper = mapper

    @Provides
    fun provideMatchMapper(mapper: ChampionshipMapperImpl): ChampionshipMapper = mapper

}