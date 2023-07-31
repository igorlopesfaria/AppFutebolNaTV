package br.com.app.futebolnatv.match.domain.usecase


import br.com.app.futebolnatv.core.usecase.BaseUseCase
import br.com.app.futebolnatv.match.domain.model.Match
import br.com.app.futebolnatv.match.domain.repository.MatchRepository
import br.com.app.futebolnatv.core.usecase.Result
import javax.inject.Inject

class FindAllMatchUseCase @Inject constructor(private val repository: MatchRepository): BaseUseCase<Void, Result<List<Match>>> {
    override suspend fun invoke(param: Void?): Result<List<Match>> = repository.getMatchList()
}