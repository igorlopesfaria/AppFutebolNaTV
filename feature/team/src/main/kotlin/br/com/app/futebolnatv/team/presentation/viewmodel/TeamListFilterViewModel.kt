package br.com.app.futebolnatv.team.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.app.futebolnatv.core.exceptions.data.NetworkException
import br.com.app.futebolnatv.core.usecase.Result
import br.com.app.futebolnatv.team.domain.model.Team
import br.com.app.futebolnatv.team.domain.usecase.FindAllTeamUseCase
import br.com.app.futebolnatv.team.presentation.model.TeamUiModel
import br.com.app.futebolnatv.team.presentation.model.mapToUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class TeamListFilterState {
    object Init : TeamListFilterState()
    object Loading : TeamListFilterState()
    object Empty : TeamListFilterState()
    data class Success(val listTeam: List<TeamUiModel>) : TeamListFilterState()
    object GenericError : TeamListFilterState()
    object InternetError : TeamListFilterState()
}

@HiltViewModel
class TeamListFilterViewModel @Inject constructor(
    private val useCase: FindAllTeamUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<TeamListFilterState>(TeamListFilterState.Init)
    val state = _state.asStateFlow()

    private val listTeamUiModel = mutableStateListOf<TeamUiModel>()
    private var oldSelectedIndex: Int = -1

    internal var teamSelected: Team? = null

    init {
        findAllTeam()
    }
    fun findAllTeam() {
        _state.update { TeamListFilterState.Loading }

        viewModelScope.launch(Dispatchers.IO) {

            when (val result = useCase.invoke()) {
                is Result.Success -> {
                    if(result.data.isNotEmpty()){
                        listTeamUiModel.addAll(result.data.map { team ->
                            team.mapToUiModel()
                        })

                        teamSelected?.let { team ->
                            listTeamUiModel.singleOrNull { item ->  item.id == team.id }?.isSelected = true
                            oldSelectedIndex = listTeamUiModel.indices.find { listTeamUiModel[it].id == team.id } ?: -1
                        }

                        _state.update { TeamListFilterState.Success(listTeamUiModel) }
                    } else {
                        _state.update { TeamListFilterState.Empty }
                    }
                }
                is Result.Error -> {
                    if(result.error is NetworkException){
                        _state.update { TeamListFilterState.InternetError }
                    } else {
                        _state.update { TeamListFilterState.GenericError }
                    }
                }
            }

        }
    }

    fun updateSelection(idSelected: Int): TeamUiModel{
        val itemSelected: TeamUiModel? = listTeamUiModel.singleOrNull {
            item ->  item.id == idSelected
        }
        val position = listTeamUiModel.indexOf(itemSelected)
        if (oldSelectedIndex> -1 && oldSelectedIndex != position) {
            // Removing old Selection
            listTeamUiModel[oldSelectedIndex] = listTeamUiModel[oldSelectedIndex].copy(isSelected = false)
        }
        itemSelected?.let {
            // Inverting new selection
            listTeamUiModel[position] = itemSelected.copy(isSelected = !itemSelected.isSelected)
            oldSelectedIndex = position
        }

        return listTeamUiModel[position]
    }



}

