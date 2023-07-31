package br.com.app.futebolnatv.channel.data.datasource


import br.com.app.futebolnatv.channel.data.datasource.dto.ChannelApiResponse
import retrofit2.http.GET

interface ChannelApiDataSource {

    @GET("channel")
    suspend fun getChannelList(): List<ChannelApiResponse>
}