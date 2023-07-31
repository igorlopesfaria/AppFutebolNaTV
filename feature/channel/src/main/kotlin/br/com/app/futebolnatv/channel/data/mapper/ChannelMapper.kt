package br.com.app.futebolnatv.channel.data.mapper

import br.com.app.futebolnatv.channel.data.datasource.dto.ChannelApiResponse
import br.com.app.futebolnatv.channel.domain.model.Channel
import javax.inject.Inject

interface ChannelMapper {
    fun mapToDomain(apiResponse: ChannelApiResponse):Channel
}

class ChannelMapperImpl @Inject constructor() : ChannelMapper {
    override fun  mapToDomain(apiResponse: ChannelApiResponse) = Channel(
        id = apiResponse.id,
        name = apiResponse.name,
        logoUrl = apiResponse.logoUrl
    )
}