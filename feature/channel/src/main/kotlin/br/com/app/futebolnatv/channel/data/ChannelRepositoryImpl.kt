package br.com.app.futebolnatv.channel.data

import br.com.app.futebolnatv.channel.data.datasource.ChannelApiDataSource
import br.com.app.futebolnatv.channel.data.mapper.ChannelMapper
import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.channel.domain.repository.ChannelRepository
import br.com.app.futebolnatv.core.network.toRequestThrowable
import br.com.app.futebolnatv.core.usecase.Result
import timber.log.Timber
import javax.inject.Inject


class ChannelRepositoryImpl @Inject constructor(
    private val apiDataSource: ChannelApiDataSource,
    private val mapper:ChannelMapper
) : ChannelRepository {


    override suspend fun getChannelList(): Result<List<Channel>> {
        return try {
            val response = apiDataSource.getChannelList().map(
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