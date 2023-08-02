package br.com.app.futebolnatv.match.presentation.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.app.futebolnatv.channel.presentation.ui.view.ChannelListLoadingView
import br.com.app.futebolnatv.designsystem.cell.DSSimpleCellLoadingView
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.dimen.DSMargin

@Composable
fun MatchListLoadingView( ) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = DSMargin.xs, vertical = DSMargin.xs)
    ) {
        items(count = 4) {
            MatchListLoadingCellView()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ChannelListLoadingViewPreview() {
    DSTheme {
        MatchListLoadingView()
    }
}