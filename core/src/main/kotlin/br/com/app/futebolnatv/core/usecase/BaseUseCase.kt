package br.com.app.futebolnatv.core.usecase


interface BaseUseCase<Param, Return> {
    suspend operator fun invoke(param: Param? = null): Return
}