package br.com.app.futebolnatv.match.data.datasource.dto


import br.com.app.futebolnatv.channel.data.datasource.dto.ChannelApiResponse
import br.com.app.futebolnatv.team.data.datasource.dto.TeamApiResponse
import com.squareup.moshi.Json

data class MatchApiResponse(
    @Json(name = "id") var  id: Int,
    @Json(name = "championship") var championship: ChampionshipApiResponse,
    @Json(name = "date") var date: String,
    @Json(name = "hour") var hour: String,
    @Json(name = "channels") var channels: List<ChannelApiResponse>,
    @Json(name = "teamHome") var teamHome: TeamApiResponse,
    @Json(name = "teamAway") var teamAway: TeamApiResponse,
)

data class ChampionshipApiResponse(
    @Json(name = "id") var  id: Int,
    @Json(name = "name") var name: String,
    @Json(name = "logoUrl") var logoUrl: String
)