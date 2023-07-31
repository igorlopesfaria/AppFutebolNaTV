package br.com.app.futebolnatv.match.domain.repository

import br.com.app.futebolnatv.core.usecase.Result
import br.com.app.futebolnatv.match.domain.model.Match


interface MatchRepository {
    suspend fun getMatchList(): Result<List<Match>>
}