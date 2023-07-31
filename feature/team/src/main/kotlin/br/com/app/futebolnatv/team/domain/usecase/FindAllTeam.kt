package br.com.app.futebolnatv.team.domain.usecase


import br.com.app.futebolnatv.core.usecase.BaseUseCase
import br.com.app.futebolnatv.team.domain.model.Team
import br.com.app.futebolnatv.team.domain.repository.TeamRepository
import br.com.app.futebolnatv.core.usecase.Result
import javax.inject.Inject

class FindAllTeamUseCase @Inject constructor(private val repository: TeamRepository): BaseUseCase<Void, Result<List<Team>>> {
    override suspend fun invoke(param: Void?): Result<List<Team>> = repository.getTeamList()
}