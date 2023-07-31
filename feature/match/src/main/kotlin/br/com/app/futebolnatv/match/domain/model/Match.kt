package br.com.app.futebolnatv.match.domain.model

import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.team.domain.model.Team

data class Match(
    var  id: Int,
    var championship: Championship,
    var date: String,
    var hour: String,
    var channels: List<Channel>,
    var teamHome: Team,
    var teamAway: Team
)

data class Championship(
    var  id: Int,
    var name: String,
    var logoUrl: String
)