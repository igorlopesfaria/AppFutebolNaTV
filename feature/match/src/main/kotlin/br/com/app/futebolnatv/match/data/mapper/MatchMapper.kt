package br.com.app.futebolnatv.match.data.mapper

import br.com.app.futebolnatv.channel.data.mapper.ChannelMapper
import br.com.app.futebolnatv.match.data.datasource.dto.ChampionshipApiResponse
import br.com.app.futebolnatv.match.data.datasource.dto.MatchApiResponse
import br.com.app.futebolnatv.match.domain.model.Championship
import br.com.app.futebolnatv.match.domain.model.Match
import br.com.app.futebolnatv.team.data.mapper.TeamMapper
import javax.inject.Inject


interface  MatchMapper {
    fun mapToDomain(apiResponse:  MatchApiResponse):  Match
}

class  MatchMapperImpl @Inject constructor(
    private val championshipMapper: ChampionshipMapper,
    private val teamMapper: TeamMapper,
    private val channelMapper: ChannelMapper
) : MatchMapper {
    override fun  mapToDomain(apiResponse:  MatchApiResponse) =  Match(
        id = apiResponse.id,
        date = apiResponse.date,
        hour = apiResponse.hour,
        championship = championshipMapper.mapToDomain(apiResponse.championship),
        teamAway = teamMapper.mapToDomain(apiResponse.teamAway),
        teamHome = teamMapper.mapToDomain(apiResponse.teamHome),
        channels = apiResponse.channels.map {
            channelMapper.mapToDomain(it)
        }
    )
}


interface ChampionshipMapper {
    fun mapToDomain(apiResponse: ChampionshipApiResponse): Championship
}

class ChampionshipMapperImpl @Inject constructor() : ChampionshipMapper {
    override fun  mapToDomain(apiResponse: ChampionshipApiResponse) = Championship(
        id = apiResponse.id,
        name = apiResponse.name,
        logoUrl = apiResponse.logoUrl
    )
}