package br.com.app.futebolnatv.team.domain.repository

import br.com.app.futebolnatv.team.domain.model.Team
import br.com.app.futebolnatv.core.usecase.Result

interface TeamRepository {
    suspend fun getTeamList(): Result<List<Team>>
}