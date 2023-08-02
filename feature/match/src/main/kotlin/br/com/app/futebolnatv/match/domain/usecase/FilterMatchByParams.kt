package br.com.app.futebolnatv.match.domain.usecase

import br.com.app.futebolnatv.core.usecase.BaseUseCase
import br.com.app.futebolnatv.match.domain.model.Match
import br.com.app.futebolnatv.match.domain.model.MatchFilter
import javax.inject.Inject

class FilterMatchByParamsUseCase @Inject constructor(): BaseUseCase<MatchFilter, List<Match>> {

    override suspend fun invoke(param: MatchFilter?): List<Match> {
        var listMatchFiltered = param?.matchList ?: return emptyList()

        param.teamNameFilter?.let { team ->
            listMatchFiltered = listMatchFiltered.filter { match ->
                match.teamAway.id == team.id || match.teamHome.id == team.id
            }
        }

        param.championshipNameFilter?.let { championship ->
            listMatchFiltered = listMatchFiltered.filter { match ->
                match.championship.id == championship.id
            }

        }
        param.channelNameFilter?.let { channel ->
            listMatchFiltered = listMatchFiltered.filter { match ->
                match.channels.contains(channel)
            }
        }

        return listMatchFiltered
    }
}