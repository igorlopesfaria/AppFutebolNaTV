package br.com.app.futebolnatv.team.di

import br.com.app.futebolnatv.team.data.TeamRepositoryImpl
import br.com.app.futebolnatv.team.data.datasource.TeamApiDataSource
import br.com.app.futebolnatv.team.data.mapper.TeamMapper
import br.com.app.futebolnatv.team.data.mapper.TeamMapperImpl
import br.com.app.futebolnatv.team.domain.repository.TeamRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class TeamDataModule {

    @Provides
    fun provideMatchRepository(repository: TeamRepositoryImpl): TeamRepository = repository

    @Provides
    fun provideTeamMapper(mapper: TeamMapperImpl): TeamMapper = mapper
}