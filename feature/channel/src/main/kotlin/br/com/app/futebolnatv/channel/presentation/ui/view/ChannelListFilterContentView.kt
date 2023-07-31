package br.com.app.futebolnatv.channel.presentation.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.app.futebolnatv.designsystem.R
import br.com.app.futebolnatv.designsystem.cell.DSSimpleCell
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.dimen.DSMargin
import br.com.app.futebolnatv.channel.presentation.model.ChannelUiModel

@Composable
fun ChannelListFilterContentView(
    listChannelUiModel: List<ChannelUiModel>,
    itemSelectedClick: (Int) -> Unit
) {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = DSMargin.xs, vertical = DSMargin.xs)
    ) {
        items(items = listChannelUiModel)  { item ->
            DSSimpleCell(
                isSelected = item.isSelected,
                label = item.name,
                id = item.id,
                urlImage = item.logoUrl,
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
fun ChannelListContentViewPreview() {
    DSTheme {
        ChannelListFilterContentView(
            listChannelUiModel = listOf(
                ChannelUiModel(name = "Bahia", id = 1, logoUrl = "", isSelected = false ),
            ),
            itemSelectedClick = {})
    }
}