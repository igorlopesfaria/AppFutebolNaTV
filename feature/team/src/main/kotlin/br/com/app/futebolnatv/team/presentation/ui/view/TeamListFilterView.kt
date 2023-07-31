package br.com.app.futebolnatv.team.presentation.ui.view

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
import br.com.app.futebolnatv.team.domain.model.Team
import br.com.app.futebolnatv.team.presentation.model.mapToDomain
import br.com.app.futebolnatv.team.presentation.viewmodel.TeamListFilterState
import br.com.app.futebolnatv.team.presentation.viewmodel.TeamListFilterViewModel

@Composable
fun TeamListFilterScreen(
    viewModel: TeamListFilterViewModel = viewModel(),
    itemSelected: Team?,
    itemSelectedClick: (Team?) -> Unit
) {

    val  onClickTryAgain : () -> Unit = {
        viewModel.findAllTeam()
    }
    viewModel.teamSelected = itemSelected
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = DSMargin.xl)
            .background(DSColor.backgroundGray)
    ) {

        Column {
            when(val teamListState  = viewModel.state.collectAsState().value) {

                is TeamListFilterState.Success -> {
                    TeamListFilterContentView(
                        listTeamUiModel = teamListState.listTeam,
                        itemSelectedClick = { idSelected ->
                            var teamUiModel = viewModel.updateSelection(idSelected)
                             if(teamUiModel.isSelected) {
                                 itemSelectedClick.invoke(teamUiModel.mapToDomain())
                            } else {
                                 itemSelectedClick.invoke(null)
                             }
                        }

                    )
                }
                TeamListFilterState.Empty -> {
                    Box (Modifier.padding(horizontal = DSMargin.md, vertical = 120.dp)) {
                        DSStatusView(
                            type = DSStatusViewType.GenericError,
                            title = "Tela Vazia",
                            description = "Não foi encontrado nenhuam partida com esses filtros aplicados",
                        )
                    }
                }
                is TeamListFilterState.GenericError -> {
                    Box (Modifier.padding(horizontal = DSMargin.md, vertical = 120.dp)) {
                        DSStatusView(
                            type = DSStatusViewType.GenericError,
                            title = "Ops! Encontramos um problema",
                            description = "Não foi possível ter listagem de partidas",
                            buttonText = "Tentar de novo",
                            onClick = onClickTryAgain
                        )
                    }
                }
                is TeamListFilterState.InternetError -> {
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
                    TeamListLoadingView()
                }
            }

        }
    }
}