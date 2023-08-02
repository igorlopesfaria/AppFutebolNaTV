package br.com.app.futebolnatv.match.presentation.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.dimen.DSMargin
import br.com.app.futebolnatv.match.domain.model.Championship
import br.com.app.futebolnatv.match.domain.model.Match
import br.com.app.futebolnatv.team.domain.model.Team


@Composable
fun MatchListContentView(
    listMatch: List<Match>
) {

    LazyColumn(
        contentPadding = PaddingValues(start = DSMargin.xs, end =DSMargin.xs , bottom = DSMargin.xs)
    ) {
        items(items = listMatch)  { item ->
            MatchListContentCellView(item)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TeamListContentViewPreview() {
    DSTheme {
        MatchListContentView(listOf(
            Match(
                id = 1,
                teamHome = Team(name = "", id = 1, shieldUrl = "", shortName = "" ),
                teamAway = Team(name = "", id = 2, shieldUrl = "", shortName = "" ),
                hour = "",
                date = "",
                channels = listOf(
                    Channel(name = "", id = 1, logoUrl = "" )
                ),
                championship = Championship(id = 1, name = "", logoUrl = "")
            ),
            Match(
                id = 2,
                teamHome = Team(name = "", id = 1, shieldUrl = "", shortName = "" ),
                teamAway = Team(name = "", id = 2, shieldUrl = "", shortName = "" ),
                hour = "",
                date = "",
                channels = listOf(
                    Channel(name = "Globo", id = 1, logoUrl = "" )
                ),
                championship = Championship(id = 1, name = "", logoUrl = "")
            ),
        ))
    }
}