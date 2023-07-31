package br.com.app.futebolnatv.team.presentation.model

import br.com.app.futebolnatv.team.domain.model.Team

data class TeamUiModel (
    var id: Int,
    var name: String,
    var shortName: String,
    var shieldUrl: String,
    var isSelected: Boolean
)

fun TeamUiModel.mapToDomain() = Team(
    id = id,
    name = name,
    shortName = shortName,
    shieldUrl = shieldUrl
)

fun Team.mapToUiModel() = TeamUiModel(
    id = id,
    name = name,
    shortName = shortName,
    shieldUrl = shieldUrl,
    isSelected = false
)