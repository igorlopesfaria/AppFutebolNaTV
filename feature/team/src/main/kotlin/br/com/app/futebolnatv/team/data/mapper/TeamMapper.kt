package br.com.app.futebolnatv.team.data.mapper

import br.com.app.futebolnatv.team.data.datasource.dto.TeamApiResponse
import br.com.app.futebolnatv.team.domain.model.Team
import javax.inject.Inject

interface TeamMapper {
    fun mapToDomain(apiResponse: TeamApiResponse):Team
}

class TeamMapperImpl @Inject constructor() : TeamMapper {
    override fun  mapToDomain(apiResponse: TeamApiResponse) = Team(
        id = apiResponse.id,
        shortName = apiResponse.shortName,
        name = apiResponse.name,
        shieldUrl = apiResponse.shieldUrl
    )
}