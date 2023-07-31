package br.com.app.futebolnatv.team.data

import br.com.app.futebolnatv.core.network.toRequestThrowable
import br.com.app.futebolnatv.team.data.datasource.TeamApiDataSource
import br.com.app.futebolnatv.team.data.mapper.TeamMapper
import br.com.app.futebolnatv.team.domain.model.Team
import br.com.app.futebolnatv.team.domain.repository.TeamRepository
import br.com.app.futebolnatv.core.usecase.Result
import timber.log.Timber
import javax.inject.Inject


class TeamRepositoryImpl @Inject constructor(
    private val apiDataSource: TeamApiDataSource,
    private val mapper:TeamMapper
) : TeamRepository {


    override suspend fun getTeamList(): Result<List<Team>> {
        return try {
            val response = apiDataSource.getTeamList().map(
                mapper::mapToDomain
            )
            Result.Success(response)

        } catch (exception: Exception) {
            Timber.e(exception.message)
            Timber.e(exception.cause)
            Result.Error(exception.toRequestThrowable())
        }

    }

}