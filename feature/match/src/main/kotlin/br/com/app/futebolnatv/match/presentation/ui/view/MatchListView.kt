package br.com.app.futebolnatv.match.presentation.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.dimen.DSMargin
import br.com.app.futebolnatv.designsystem.statusview.DSStatusView
import br.com.app.futebolnatv.designsystem.statusview.DSStatusViewType
import br.com.app.futebolnatv.match.presentation.viewmodel.MatchListFilterState
import br.com.app.futebolnatv.match.presentation.viewmodel.MatchListViewModel
import br.com.app.futebolnatv.team.domain.model.Team

@Composable
fun MatchListView(
    viewModel: MatchListViewModel = hiltViewModel(),
    channelSelected: Channel?,
    teamSelected: Team?,
    shouldFilter: Boolean,
    onClickClearFilter: (() -> Unit)
) {

    val onClickTryAgain: () -> Unit = {
        viewModel.findAllMatchList()
    }
    viewModel.channelSelected = channelSelected
    viewModel.teamSelected = teamSelected
    if(shouldFilter) {
        viewModel.filterListMatch()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DSColor.backgroundGray)
    ) {

        Column {
            when (val matchListState = viewModel.state.collectAsState().value) {

                is MatchListFilterState.Success -> {
                    MatchListContentView(listMatch = matchListState.listMatch)
                }

                MatchListFilterState.Empty -> {
                    Box(Modifier.padding(horizontal = DSMargin.md, vertical = 120.dp)) {
                        DSStatusView(
                            type = DSStatusViewType.GenericError,
                            title = "Nenhuma partida encontrada",
                            description = "Reveja os filtros aplicados.",
                            buttonText = "Limpar Filtro",
                            onClick = {
                                onClickClearFilter.invoke()
                                viewModel.channelSelected = null
                                viewModel.teamSelected = null
                                viewModel.filterListMatch()
                            }

                        )
                    }
                }

                is MatchListFilterState.GenericError -> {
                    Box(Modifier.padding(horizontal = DSMargin.md, vertical = 120.dp)) {
                        DSStatusView(
                            type = DSStatusViewType.GenericError,
                            title = "Ops! Encontramos um problema",
                            description = "Não foi possível ter listagem de canais",
                            buttonText = "Tentar de novo",
                            onClick = onClickTryAgain
                        )
                    }
                }

                is MatchListFilterState.InternetError -> {
                    Box(Modifier.padding(horizontal = DSMargin.md, vertical = 120.dp)) {
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
                    MatchListLoadingView()
                }
            }

        }
    }
}