package br.com.app.futebolnatv.channel.presentation.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.dimen.DSMargin
import br.com.app.futebolnatv.designsystem.statusview.DSStatusView
import br.com.app.futebolnatv.designsystem.statusview.DSStatusViewType
import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.channel.presentation.model.mapToDomain
import br.com.app.futebolnatv.channel.presentation.viewmodel.ChannelListFilterState
import br.com.app.futebolnatv.channel.presentation.viewmodel.ChannelListFilterViewModel

@Composable
fun ChannelListFilterView(
    viewModel: ChannelListFilterViewModel = viewModel(),
    itemSelected: Channel?,
    itemSelectedClick: (Channel?) -> Unit
) {

    val  onClickTryAgain : () -> Unit = {
        viewModel.findAllChannel()
    }
    viewModel.channelSelected = itemSelected
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = DSMargin.xl)
            .background(DSColor.backgroundGray)
    ) {

        Column {
            when(val channelListState  = viewModel.state.collectAsState().value) {

                is ChannelListFilterState.Success -> {
                    ChannelListFilterContentView(
                        listChannelUiModel = channelListState.listChannel,
                        itemSelectedClick = { idSelected ->
                            var channelUiModel = viewModel.updateSelection(idSelected)
                             if(channelUiModel.isSelected) {
                                 itemSelectedClick.invoke(channelUiModel.mapToDomain())
                            } else {
                                 itemSelectedClick.invoke(null)
                             }
                        }

                    )
                }
                ChannelListFilterState.Empty -> {
                    Box (Modifier.padding(horizontal = DSMargin.md, vertical = 120.dp)) {
                        DSStatusView(
                            type = DSStatusViewType.GenericError,
                            title = "Tela Vazia",
                            description = "Não foi encontrado nenhum canal.",
                        )
                    }
                }
                is ChannelListFilterState.GenericError -> {
                    Box (Modifier.padding(horizontal = DSMargin.md, vertical = 120.dp)) {
                        DSStatusView(
                            type = DSStatusViewType.GenericError,
                            title = "Ops! Encontramos um problema",
                            description = "Não foi possível ter listagem de canais",
                            buttonText = "Tentar de novo",
                            onClick = onClickTryAgain
                        )
                    }
                }
                is ChannelListFilterState.InternetError -> {
                    Box (Modifier.padding(horizontal = DSMargin.md, vertical = 120.dp)) {
                        DSStatusView(
                            type = DSStatusViewType.GenericError,
                            title = "Ops! Problema de conexão",
                            description = "Verifique sua conexão e tente novamente refazer a requisição.",
                            buttonText = "Tentar de novo",
                            onClick = onClickTryAgain
                        )
                    }
                }
                else -> {
                    ChannelListLoadingView()
                }
            }

        }
    }
}