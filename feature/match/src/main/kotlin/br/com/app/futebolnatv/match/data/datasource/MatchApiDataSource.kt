package br.com.app.futebolnatv.match.data.datasource

import br.com.app.futebolnatv.match.data.datasource.dto.MatchApiResponse
import retrofit2.http.GET

interface MatchApiDataSource {

    @GET("team")
    suspend fun getMatchList(): List<MatchApiResponse>
}