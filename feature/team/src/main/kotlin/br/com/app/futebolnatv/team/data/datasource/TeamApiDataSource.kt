package br.com.app.futebolnatv.team.data.datasource


import br.com.app.futebolnatv.team.data.datasource.dto.TeamApiResponse
import retrofit2.http.GET

interface TeamApiDataSource {

    @GET("team")
    suspend fun getTeamList(): List<TeamApiResponse>
}