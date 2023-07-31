package br.com.app.futebolnatv.channel.data.datasource.dto
import com.squareup.moshi.Json

data class ChannelApiResponse(
    @Json(name = "id") var  id: Int,
    @Json(name = "name") var name: String,
    @Json(name = "logoUrl") var logoUrl: String
)