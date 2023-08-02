package br.com.app.futebolnatv.match.domain.model

import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.team.domain.model.Team


data class MatchFilter (
    val teamNameFilter: Team? = null,
    val channelNameFilter: Channel? = null,
    val championshipNameFilter: Championship? = null,
    val matchList: List<Match>,
)