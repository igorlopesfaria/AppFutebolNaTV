package br.com.app.futebolnatv.channel.domain.usecase


import br.com.app.futebolnatv.core.usecase.BaseUseCase
import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.channel.domain.repository.ChannelRepository
import br.com.app.futebolnatv.core.usecase.Result
import javax.inject.Inject

class FindAllChannelUseCase @Inject constructor(private val repository: ChannelRepository): BaseUseCase<Void, Result<List<Channel>>> {
    override suspend fun invoke(param: Void?): Result<List<Channel>> = repository.getChannelList()
}