package br.com.app.futebolnatv.channel.presentation.model

import br.com.app.futebolnatv.channel.domain.model.Channel

data class ChannelUiModel (
    var id: Int,
    var name: String,
    var logoUrl: String,
    var isSelected: Boolean
)

fun ChannelUiModel.mapToDomain() = Channel(
    id = id,
    name = name,
    logoUrl = logoUrl
)

fun Channel.mapToUiModel() = ChannelUiModel(
    id = id,
    name = name,
    logoUrl = logoUrl,
    isSelected = false
)