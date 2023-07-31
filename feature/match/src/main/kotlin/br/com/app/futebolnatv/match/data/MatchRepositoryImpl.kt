package br.com.app.futebolnatv.match.data

import br.com.app.futebolnatv.core.network.toRequestThrowable
import br.com.app.futebolnatv.core.usecase.Result
import br.com.app.futebolnatv.match.data.datasource.MatchApiDataSource
import br.com.app.futebolnatv.match.data.mapper.MatchMapper
import br.com.app.futebolnatv.match.domain.model.Match
import br.com.app.futebolnatv.match.domain.repository.MatchRepository
import timber.log.Timber
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val apiDataSource: MatchApiDataSource,
    private val mapper: MatchMapper
) : MatchRepository {


    override suspend fun getMatchList(): Result<List<Match>> {
        return try {
            val response = apiDataSource.getMatchList().map(
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