package br.com.app.futebolnatv.team.presentation.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.app.futebolnatv.designsystem.R
import br.com.app.futebolnatv.designsystem.cell.DSSimpleCell
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.dimen.DSMargin
import br.com.app.futebolnatv.team.presentation.model.TeamUiModel

@Composable
fun TeamListFilterContentView(
    listTeamUiModel: List<TeamUiModel>,
    itemSelectedClick: (Int) -> Unit
) {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = DSMargin.xs, vertical = DSMargin.xs)
    ) {
        items(items = listTeamUiModel)  { item ->
            DSSimpleCell(
                isSelected = item.isSelected,
                label = item.name,
                id = item.id,
                urlImage = item.shieldUrl,
                placeholder = R.drawable.ic_shield_sm,
                onClick = { itemSelectedId ->
                    itemSelectedClick.invoke(itemSelectedId)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TeamListContentViewPreview() {
    DSTheme {
        TeamListFilterContentView(
            listTeamUiModel = listOf(
                TeamUiModel(name = "Bahia", id = 1, shieldUrl = "", shortName = "", isSelected = false ),
            ),
            itemSelectedClick = {})
    }
}