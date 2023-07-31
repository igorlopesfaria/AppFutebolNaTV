package br.com.app.futebolnatv.channel.domain.repository

import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.core.usecase.Result

interface ChannelRepository {
    suspend fun getChannelList(): Result<List<Channel>>
}