package br.com.app.futebolnatv.channel.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.app.futebolnatv.core.exceptions.data.NetworkException
import br.com.app.futebolnatv.core.usecase.Result
import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.channel.domain.usecase.FindAllChannelUseCase
import br.com.app.futebolnatv.channel.presentation.model.ChannelUiModel
import br.com.app.futebolnatv.channel.presentation.model.mapToUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class ChannelListFilterState {
    object Init : ChannelListFilterState()
    object Loading : ChannelListFilterState()
    object Empty : ChannelListFilterState()
    data class Success(val listChannel: List<ChannelUiModel>) : ChannelListFilterState()
    object GenericError : ChannelListFilterState()
    object InternetError : ChannelListFilterState()
}

@HiltViewModel
class ChannelListFilterViewModel @Inject constructor(
    private val useCase: FindAllChannelUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<ChannelListFilterState>(ChannelListFilterState.Init)
    val state = _state.asStateFlow()

    private val listChannelUiModel = mutableStateListOf<ChannelUiModel>()
    private var oldSelectedIndex: Int = -1

    internal var channelSelected: Channel? = null

    init {
        findAllChannel()
    }
    fun findAllChannel() {
        _state.update { ChannelListFilterState.Loading }

        viewModelScope.launch(Dispatchers.IO) {

            when (val result = useCase.invoke()) {
                is Result.Success -> {
                    if(result.data.isNotEmpty()){
                        listChannelUiModel.addAll(result.data.map { channel ->
                            channel.mapToUiModel()
                        })

                        channelSelected?.let { channel ->
                            listChannelUiModel.singleOrNull { item ->  item.id == channel.id }?.isSelected = true
                            oldSelectedIndex = listChannelUiModel.indices.find { listChannelUiModel[it].id == channel.id } ?: -1
                        }

                        _state.update { ChannelListFilterState.Success(listChannelUiModel) }
                    } else {
                        _state.update { ChannelListFilterState.Empty }
                    }
                }
                is Result.Error -> {
                    if(result.error is NetworkException){
                        _state.update { ChannelListFilterState.InternetError }
                    } else {
                        _state.update { ChannelListFilterState.GenericError }
                    }
                }
            }

        }
    }

    fun updateSelection(idSelected: Int): ChannelUiModel{
        val itemSelected: ChannelUiModel? = listChannelUiModel.singleOrNull {
            item ->  item.id == idSelected
        }
        val position = listChannelUiModel.indexOf(itemSelected)
        if (oldSelectedIndex> -1 && oldSelectedIndex != position) {
            // Removing old Selection
            listChannelUiModel[oldSelectedIndex] = listChannelUiModel[oldSelectedIndex].copy(isSelected = false)
        }
        itemSelected?.let {
            // Inverting new selection
            listChannelUiModel[position] = itemSelected.copy(isSelected = !itemSelected.isSelected)
            oldSelectedIndex = position
        }

        return listChannelUiModel[position]
    }



}

