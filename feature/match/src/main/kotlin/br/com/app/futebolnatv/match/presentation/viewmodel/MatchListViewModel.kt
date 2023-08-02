package br.com.app.futebolnatv.match.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.channel.presentation.model.mapToUiModel
import br.com.app.futebolnatv.core.exceptions.data.NetworkException
import br.com.app.futebolnatv.core.usecase.Result
import br.com.app.futebolnatv.match.domain.model.Championship
import br.com.app.futebolnatv.match.domain.model.Match
import br.com.app.futebolnatv.match.domain.model.MatchFilter
import br.com.app.futebolnatv.match.domain.usecase.FilterMatchByParamsUseCase
import br.com.app.futebolnatv.match.domain.usecase.FindAllMatchUseCase
import br.com.app.futebolnatv.team.domain.model.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class MatchListFilterState {
    object Init : MatchListFilterState()
    object Loading : MatchListFilterState()
    object Empty : MatchListFilterState()
    data class Success(val listMatch: List<Match>) : MatchListFilterState()
    object GenericError : MatchListFilterState()
    object InternetError : MatchListFilterState()
}
@HiltViewModel
class MatchListViewModel @Inject constructor(
    private val findAllMatchUseCase: FindAllMatchUseCase,
    private val filterMatchByParamsUseCase: FilterMatchByParamsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<MatchListFilterState>(MatchListFilterState.Init)
    val state = _state.asStateFlow()

    private val listMatch = mutableStateListOf<Match>()
    private var listMatchOriginal = listOf<Match>()


    var channelSelected: Channel? = null
    var teamSelected: Team? = null
    var championshipSelected: Championship? = null
    init {
        findAllMatchList()
    }
    fun findAllMatchList() {
        _state.update { MatchListFilterState.Loading }

        viewModelScope.launch(Dispatchers.IO) {

            when (val result = findAllMatchUseCase.invoke()) {
                is Result.Success -> {
                    if(result.data.isNotEmpty()){
                        listMatchOriginal = result.data
                        listMatch.addAll(listMatchOriginal.map { it })
                        _state.update { MatchListFilterState.Success(listMatch) }
                    } else {
                        _state.update { MatchListFilterState.Empty }
                    }
                }
                is Result.Error -> {
                    if(result.error is NetworkException){
                        _state.update { MatchListFilterState.InternetError }
                    } else {
                        _state.update { MatchListFilterState.GenericError }
                    }
                }
            }

        }
    }

    fun filterListMatch() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { MatchListFilterState.Loading }
            val listFiltered = filterMatchByParamsUseCase.invoke(
                param = MatchFilter(
                    matchList = listMatchOriginal,
                    championshipNameFilter = championshipSelected,
                    teamNameFilter = teamSelected,
                    channelNameFilter = channelSelected
                )
            )
            listMatch.clear()
            if(listFiltered.isEmpty()) {
                _state.update { MatchListFilterState.Empty }
            } else {
                listMatch.addAll(listFiltered.map { it })
                _state.update { MatchListFilterState.Success(listMatch) }
            }
        }
    }
}
