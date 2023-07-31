package br.com.app.futebolnatv.match.domain.usecase

import br.com.app.futebolnatv.core.usecase.BaseUseCase
import br.com.app.futebolnatv.match.domain.model.Match
import br.com.app.futebolnatv.match.domain.model.MatchFilter
import javax.inject.Inject

class FilterMatchByParamsUseCase @Inject constructor(): BaseUseCase<MatchFilter, List<Match>> {

    override suspend fun invoke(param: MatchFilter?): List<Match> {
        var listMatchFiltered = param?.matchList ?: return emptyList()
        if (param.teamNameFilter.isNotEmpty())  {
            listMatchFiltered = listMatchFiltered.filter { match ->
                match.teamAway.name == param.teamNameFilter ||  match.teamHome.name == param.teamNameFilter
            }
        }

        if (param.championshipNameFilter.isNotEmpty())  {
            listMatchFiltered = listMatchFiltered.filter { match ->
                match.championship.name == param.championshipNameFilter }
        }

        return listMatchFiltered
    }
}