package br.com.app.futebolnatv.team.data.datasource.dto
import com.squareup.moshi.Json

data class TeamApiResponse(
    @Json(name = "id") var  id: Int,
    @Json(name = "shortName") var shortName: String,
    @Json(name = "name") var name: String,
    @Json(name = "shieldUrl") var shieldUrl: String
)