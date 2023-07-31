package br.com.app.futebolnatv.match.domain.model


data class MatchFilter (
    val teamNameFilter: String = "",
    val championshipNameFilter: String = "",
    val matchList: List<Match>,
)